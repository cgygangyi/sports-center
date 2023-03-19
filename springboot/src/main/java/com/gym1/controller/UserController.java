package com.gym1.controller;

import com.gym1.entity.User;
import com.gym1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public int login(@RequestParam Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        User res = userService.loginService(username);
        if (res == null){
            return 0;
        }else if(res.getPassword().equals(password)){
            return 1;
        }else{
            return -1;
        }
    }

    @PostMapping("/register")
    public int register(@RequestParam Map<String,String> map){
        

    }



}
