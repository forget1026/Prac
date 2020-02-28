package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;    

    @Override
    public List<UserDto> selectUserList() throws Exception {
        return userMapper.selectUserList();
    }

    @Override
    public UserDto selectUser(int userIdx) throws Exception {
        return userMapper.selectUser(userIdx);
    }
}