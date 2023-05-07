package com.gym1.service;


import com.gym1.entity.User;
import com.gym1.mapper.UserMapper;
import com.gym1.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.*;



@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;


    public int registerService(Map map){
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String phoneNumber = map.get("phoneNumber").toString();
        String name = map.get("name").toString();
        String email = map.get("email").toString();
        User user = new User(username, password, phoneNumber, name, email);
        String sex = map.get("sex").toString();
        String age = map.get("age").toString();
        if (age != null){
            user.setAge(Integer.parseInt(age));
        }else{
            user.setAge(-1);
        }
        if (sex.equals("None")){
            user.setSex(-1);
        }else if (sex.equals("Female")){
            user.setSex(0);
        } else if (sex.equals("Male")) {
            user.setSex(1);
        }else{
            user.setSex(-1);
        }
        int res = 0;
        try{
            res = userMapper.addUser(user);
            return res;
        }catch (Exception e){
            return -1;
        }
    }


    public Map<String, User> updateUserInfo(int id, Map<String, String> map){
        String password = map.get("password");
        String phoneNumber = map.get("phoneNumber");
        String name = map.get("name");
        User user = new User(id, password, phoneNumber, name);
        String sex = map.get("sex");
        String age = map.get("age");
        if (age != null){
            user.setAge(Integer.parseInt(age));
        }else{
            user.setAge(-1);
        }
        if (sex.equals("None")){
            user.setSex(-1);
        }else if (sex.equals("Female")){
            user.setSex(0);
        } else if (sex.equals("Male")) {
            user.setSex(1);
        }else{
            user.setSex(-1);
        }
        int res = 0;
        try{
            res = userMapper.editUser(user);
        }catch (Exception e){
            res = -1;
        }
        User user1 = new User(res);
        Map<String, User> reMap = new HashMap<>();
        reMap.put("user", user);
        reMap.put("res", user1);
        return reMap;
    }

    public User loginService(String username){
        return userMapper.queryUserByUsername(username);
    }

    public List<User> getAllUser(){
        return userMapper.queryAllUser();
    }

    public User getUserInfo(int id){
        return userMapper.queryUserById(id);
    }

    public int updateProfile(int id, String image){
        int res = 0;
        try{
            res = userMapper.updateUserImage(id, image);
            return res;
        }catch (Exception e){
            return -1;
        }
    }

    public User adminLoginService(String username){
        return userMapper.queryUserByUsername2(username);
    }

    public User rootLoginService(String username){
        return userMapper.queryUserByUsername3(username);
    }

    public int manageAdmin(int id, int num){
        int res = 0;
        try{
            res = userMapper.updateUserAdminById(id, num);
            return res;
        }catch (Exception e){
            return -1;
        }
    }

    public int updateCard(String card, int id){
        int res = 0;
        try{
            res = userMapper.updateUserCardById(id, card);
            return res;
        }catch (Exception e){
            return -1;
        }
    }

    public int subscribe(int id, int num){
        User user = userMapper.queryUserById(id);
        int res = 0;
        if (user.getIsMember() == 1){
            Date date = user.getMembership();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, num);
            date = calendar.getTime();
            try{
                res = userMapper.updateUserMembershipById(id, date);
                return res;
            }catch (Exception e){
                return -1;
            }
        }else{
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, num);
            Date date = calendar.getTime();
            try{
                res = userMapper.updateUserMembershipById(id, date);
                return res;
            }catch (Exception e){
                return -1;
            }
        }
    }

    public String verifyUsername(String username, String email){
        if(userMapper.queryUserByUsername(username) != null){
            return "0";
        }else{
            try{
                String code = "";
                Random random = new Random();
                for (int i = 0; i < 6; i++) {
                    code = code + random.nextInt(10);
                }
                String content = EmailUtil.codeEmail(code);
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
                mimeMessageHelper.setFrom(from);
                mimeMessageHelper.setTo(email);
                mimeMessageHelper.setSubject("Verification Code");
                mimeMessageHelper.setText(content, true);
                mailSender.send(message);
                return code;
            }catch (Exception e){
                return "1";
            }
        }
    }


}
