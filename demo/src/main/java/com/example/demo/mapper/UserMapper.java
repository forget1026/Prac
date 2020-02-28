package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dto.UserDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    List<UserDto> selectUserList() throws Exception;
    UserDto selectUser(int userIdx) throws Exception;
}