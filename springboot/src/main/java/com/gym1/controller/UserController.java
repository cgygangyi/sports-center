package com.gym1.controller;


import com.gym1.entity.User;
import com.gym1.service.UserService;
import com.gym1.service.VenueService;
import com.gym1.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        User res = userService.loginService(username);
        Map<String, Object> reMap = new HashMap<>();
        if (res == null){
            reMap.put("code", 7001);
            reMap.put("message", "Username doesn't exist!");
            return reMap;
        }else if(res.getPassword().equals(password)){
            String id = res.getId() + "";
            String token = JwtUtil.getJwtToken(id, username, password);
            reMap.put("code", 7002);
            reMap.put("message", "Login successfully!");
            reMap.put("data", token);
            return reMap;
        }else{
            reMap.put("code", 7003);
            reMap.put("message", "Password isn't correct!");
            return reMap;
        }
    }


    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map map){
        Map<String, Object> reMap = new HashMap<>();
        int res = userService.registerService(map);
        if (res == -2){
            reMap.put("code", 7004);
            reMap.put("msg", "The username has existed!");
            reMap.put("data", res);
        }else if(res == -1){
            reMap.put("code", 7005);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if(res == 0){
            reMap.put("code", 7006);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 7007);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @PostMapping("/updateInfo")
    public Map<String, Object> updateInfo(HttpServletRequest request, @RequestBody Map map){
        Map<String, Object> reMap = new HashMap<>();
        int id = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        Map<String, User> temp = userService.updateUserInfo(id, map);
        User user = temp.get("user");
        String token = JwtUtil.getJwtToken(user.getId()+"", user.getUsername(), user.getPassword());
        int res = temp.get("res").getId();
        if (res == -1 ){
            reMap.put("code", 7008);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if (res == 0){
            reMap.put("code", 7009);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 7010);
            reMap.put("msg", "Success!");
            reMap.put("data", token);
        }
        return reMap;
    }

    @GetMapping("/getUserInfo")
    public Map<String, Object> getUserInfo(HttpServletRequest request){
        int id = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        User user = userService.getUserInfo(id);
        Map<String, Object> reMap = new HashMap<>();
        reMap.put("code", 7011);
        reMap.put("msg", "Success!");
        reMap.put("data", user);
        return reMap;
    }


    @PostMapping("/updateProfile")
    public Map<String, Object> updateProfile(HttpServletRequest request, @RequestBody Map<String,String> map){
        int id = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        String image = map.get("upload");
        int res = userService.updateProfile(id, "data:image/png;base64,"+image);
        Map<String, Object> reMap = new HashMap<>();
        if (res == -1){
            reMap.put("code", 7012);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if(res == 0){
            reMap.put("code", 7013);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 7014);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }



}
