package com.gym1.controller;

import com.gym1.entity.User;
import com.gym1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public int login(@RequestParam Map map){

        String username = (String) map.get("username");
        String password = (String) map.get("password");

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
        String username = map.get("username");
        String password = map.get("password");
        String name = map.get("name");
        String phoneNumber = map.get("phoneNumber");
        String email = map.get("email");
        int age = Integer.parseInt(map.get("age"));
        String sex = map.get("sex");

        User user = new User(username,password,name,phoneNumber,email,age,sex);
        int res = userService.registerService(user);
        return res;

    }



}
