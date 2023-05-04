package com.gym1.controller;


import com.gym1.entity.User;
import com.gym1.service.UserService;
import com.gym1.service.VenueService;
import com.gym1.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    private UserService userService;
    @Autowired
    private VenueService venueService;

    @PostMapping("/login")
    public Map<String, Object> login(HttpSession session, @RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        User res = userService.loginService(username);
        Map<String, Object> reMap = new HashMap<>();
        if (res == null){
            reMap.put("code", 4000);
            reMap.put("message", "Username doesn't exist!");
            return reMap;
        }else if(res.getPassword().equals(password)){
            String id = res.getId() + "";
            String token = JwtUtil.getJwtToken(id, username, password);
            reMap.put("code", 4002);
            reMap.put("message", "Login successfully!");
            reMap.put("data", token);
            return reMap;
        }else{
            reMap.put("code", 4001);
            reMap.put("message", "Password isn't correct!");
            return reMap;
        }
    }

    @PostMapping("/register")
    public int register(@RequestBody Map<String,String> map){
        return userService.registerService(map);
    }

    @GetMapping("/getUserInfo")
    public Map<String, Object> getUserInfo(HttpServletRequest request){
        int id = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        User user = userService.getUserInfo(id);
        Map<String, Object> reMap = new HashMap<>();
        reMap.put("code", 4004);
        reMap.put("msg", "Success!");
        reMap.put("data", user);
        return reMap;
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
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
            reMap.put("code", 4005);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if (res == 0){
            reMap.put("code", 4006);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 4007);
            reMap.put("msg", "Success!");
            reMap.put("data", token);
        }
        return reMap;
    }

}
