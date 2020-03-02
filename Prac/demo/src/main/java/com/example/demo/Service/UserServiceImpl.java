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

    @Override
    public boolean insertUser(UserDto user) throws Exception {
        return userMapper.insertUser(user);
    }

    @Override
    public UserDto updateUser(UserDto user) throws Exception {
        userMapper.updateUser(user);
        return userMapper.selectUser(user.getNo());
    }

    @Override
    public boolean deleteUser(int userIdx) throws Exception {
        userMapper.deleteUser(userIdx);
        return true;
    }
}