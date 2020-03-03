package day4.back.backend.Service;

import java.util.List;

import day4.back.backend.DTO.ElectricityBill;

public interface ElectricService {
    public List<ElectricityBill> selectAll() throws Exception;
}