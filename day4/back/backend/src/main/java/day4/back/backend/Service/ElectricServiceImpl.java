package day4.back.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day4.back.backend.DTO.ElectricityBill;
import day4.back.backend.Mapper.ElectricMapper;

@Service
public class ElectricServiceImpl implements ElectricService {
    @Autowired
    private ElectricMapper electricMapper;

    @Override
    public List<ElectricityBill> selectAll() throws Exception {
        return electricMapper.selectAll();
    }
}