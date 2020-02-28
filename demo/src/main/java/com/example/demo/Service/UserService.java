package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {
    public List<UserDto> selectUserList() throws Exception;
    public UserDto selectUser(int userIdx) throws Exception;
}