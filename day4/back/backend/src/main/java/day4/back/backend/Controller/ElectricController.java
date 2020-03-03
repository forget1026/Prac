package day4.back.backend.Controller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import day4.back.backend.DTO.ElectricityBill;
import day4.back.backend.Service.ElectricService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ElectricController {
    @Autowired
    private ElectricService electricService;

    @GetMapping(value="/")
    @ResponseBody
    public List<ElectricityBill> getAllData() throws Exception{
        return electricService.selectAll();
    }

    @RequestMapping(value="/excel", method=RequestMethod.GET)
    public ResponseEntity<byte[]> excelDownload() throws Exception{
        List<ElectricityBill> list = electricService.selectAll();
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("test");
        Row row = null;
        Cell cell = null;
    
        int rowNo = 0;
        // 테이블 헤더용 스타일
        CellStyle headStyle = wb.createCellStyle();
    
        // 가는 경계선을 가집니다.
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);

        // 배경색은 노란색입니다.    
        headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        // 데이터는 가운데 정렬합니다.
        headStyle.setAlignment(HorizontalAlignment.CENTER);

        // 데이터용 경계 스타일 테두리만 지정    
        CellStyle bodyStyle = wb.createCellStyle();
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
    
        // 헤더 생성
        row = sheet.createRow(rowNo++);
        cell = row.createCell(0);
        cell.setCellStyle(headStyle);
        cell.setCellValue("일시");
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("전기소비량(kWh)");
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("단가(원)");
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("전기요금(원)");

        // 데이터 부분 생성
        for(ElectricityBill vo : list) {
            row = sheet.createRow(rowNo++);
            cell = row.createCell(0);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getHour());
            cell = row.createCell(1);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getConsumption());
            cell = row.createCell(2);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getUnitPrice());
            cell = row.createCell(2);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(vo.getCost());
        }
        // 컨텐츠 타입과 파일명 지정
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        wb.write(os);
        os.close();
        wb.close();
        String contentType = "application/vnd.ms-excel";
        String downFileNm = "test";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + downFileNm + "\"")
                .body(os.toByteArray());
    }
    
}