package com.gym1.controller;

import com.gym1.entity.User;
import com.gym1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public int login(@RequestBody Map map){
        System.out.println(map.get("username") + " , " + map.get("password"));
//        User res = userService.loginService(username);
//        if (res == null){
//            return 0;
//        }else if(res.getPassword().equals(password)){
//            return 1;
//        }else{
//            return -1;
//        }
        return 1;
    }

    //@PostMapping("/register")
    //public int register(@RequestParam Map<String,String> map){


    //}



}
