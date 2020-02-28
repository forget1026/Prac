package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping({"/users", "/"})
    public List<UserDto> userList() throws Exception {
        return userService.selectUserList();
    }

    @ResponseBody
    @RequestMapping({"/users/{userIdx}"})
    public UserDto userDetail(@PathVariable("userIdx")int userIdx) throws Exception {
        return userService.selectUser(userIdx);
    }
}