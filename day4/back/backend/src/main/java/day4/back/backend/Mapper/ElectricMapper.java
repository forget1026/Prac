package day4.back.backend.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import day4.back.backend.DTO.ElectricityBill;

@Mapper
public interface ElectricMapper {
    List<ElectricityBill> selectAll() throws Exception;
}