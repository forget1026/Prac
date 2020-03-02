package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {
    public List<UserDto> selectUserList() throws Exception;
    public UserDto selectUser(int userIdx) throws Exception;
    public boolean insertUser(UserDto user) throws Exception;
    public UserDto updateUser(UserDto user) throws Exception;
    public boolean deleteUser(int userIdx) throws Exception;
}