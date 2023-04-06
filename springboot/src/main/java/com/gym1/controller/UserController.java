package com.gym1.controller;

import com.gym1.entity.User;
import com.gym1.service.UserService;
import com.gym1.service.VenueService;
import com.gym1.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String login(HttpSession session, @RequestBody Map map){

        String username = (String) map.get("username");
        String password = (String) map.get("password");
        User res = userService.loginService(username);
        if (res == null){
            return null;
        }else if(res.getPassword().equals(password)){
//            HttpSession session = request.getSession();
            System.out.println(session);
            if(session.getAttribute("user") != null){
                session.removeAttribute("user");
            }
            session.setAttribute("user", res);
            System.out.println(session.getAttribute("user"));
            TokenUtil tokenUtil = new TokenUtil();
            return tokenUtil.getToken(username, password);
        }else{
            return null;
        }
    }

    @PostMapping("/register")
    public int register(@RequestParam Map<String,String> map){
        return userService.registerService(map);
    }

    @PostMapping("/logOut")
    public int logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return 1;
    }

    @PostMapping("/ifLogin")
    public int register(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            return 0;
        }else{
            return 1;
        }
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }

}
