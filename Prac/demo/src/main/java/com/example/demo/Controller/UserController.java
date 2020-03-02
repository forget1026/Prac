package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/users", "/"}, method = RequestMethod.GET)
    public List<UserDto> userList() throws Exception {
        return userService.selectUserList();
    }

    @RequestMapping(value={"/users/{userIdx}"}, method = RequestMethod.GET)
    public UserDto userDetail(@PathVariable("userIdx")int userIdx) throws Exception {
        return userService.selectUser(userIdx);
    }

    @PostMapping(value="/users")
    public HashMap<String, String> insertUser(@RequestBody UserDto user) throws Exception {
        HashMap<String, String> result = new HashMap<>();
        if (userService.insertUser(user)){
            result.put("Message", "Success");
        } else {
            result.put("Message", "Fail");
        }        
        return result;
    }

    @PutMapping(value="/users/{userIdx}")
    public UserDto updateUser(@PathVariable("userIdx") int userIdx, @RequestBody UserDto user) throws Exception {
        user.setNo(userIdx);
        return userService.updateUser(user);
    }

    @PostMapping(value="/users/update")
    public UserDto updateUserByUpdate(@RequestBody UserDto user) throws Exception{
        return userService.updateUser(user);
    }
    
    @DeleteMapping(value="/users/{userIdx}")
    public HashMap<String, String> deleteUser(@PathVariable("userIdx")int userIdx) throws Exception {
        HashMap<String, String> result = new HashMap<>();
        if (userService.deleteUser(userIdx)){
            result.put("Message", "Success");
        } else {
            result.put("Message", "Fail");
        }        
        return result;
    }

    @PostMapping(value = "/users/delete")
    public HashMap<String, String> deleteUserByDelete(@RequestBody UserDto user) throws Exception {
        HashMap<String, String> result = new HashMap<>();
        if (userService.deleteUser(user.getNo())){
            result.put("Message", "Success");
        } else {
            result.put("Message", "Fail");
        }
        return result;
    }  
}