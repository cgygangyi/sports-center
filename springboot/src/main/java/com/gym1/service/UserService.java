package com.gym1.service;

import com.gym1.entity.User;
import com.gym1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int registerService(User user){
        return userMapper.addUser(user);
    }

    public User loginService(String username){
        return userMapper.queryUserByUsername(username);
    }



}
