package com.gym1.service;


import com.gym1.entity.User;
import com.gym1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int registerService(Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        String name = map.get("name");
        String email = map.get("email");
        String phoneNumber = map.get("phoneNumber");

        User user = new User(username, password, name, phoneNumber, email);

        System.out.println("================================");
        System.out.println(map.get("age") == null);
        System.out.println(map.get("sex"));
        if(map.get("age")==null && map.get("sex").equals("None")){

        }else if(map.get("sex").equals("None")){
            int age = Integer.parseInt(map.get("age"));
            user.setAge(age);
        }else if(map.get("age")==null){
            System.out.println(user);
            int sex = 1;
            if(map.get("sex").equals("Female")){
                sex = 0;
            }
            user.setSex(sex);
        }else{
            int age = Integer.parseInt(map.get("age"));
            int sex = 1;
            if(map.get("sex").equals("Female")){
                sex = 0;
            }
            user.setSex(sex);
            user.setAge(age);
        }

        if(userMapper.queryUserByUsername(username) != null){
            return -1;
        }
        return userMapper.addUser(user);

    }

    public User loginService(String username){
        return userMapper.queryUserByUsername(username);
    }



}
