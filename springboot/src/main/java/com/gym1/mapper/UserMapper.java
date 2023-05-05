package com.gym1.mapper;

import com.gym1.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int addUser(User user);

    List<User> queryAllUser();

    User queryUserByUsername(String username);

    User queryUserByUsername2(String username);

    User queryUserByUsername3(String username);

    int editUser(User user);

    User queryUserById(int id);

    int updateUserImage(int id, String image);

}
