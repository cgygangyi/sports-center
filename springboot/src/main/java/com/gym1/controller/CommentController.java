package com.gym1.controller;


import com.gym1.entity.Order;
import com.gym1.service.CommentService;
import com.gym1.service.OrderService;
import com.gym1.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/makeComment/{orderId}")
    public Map<String, Object> makeComment(HttpServletRequest request,@PathVariable int orderId,
                                           @RequestBody Map map){
        Map<String, Object> reMap = new HashMap<>();
        int uId = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        String info = map.get("comment").toString();
        int res = commentService.makeComment(uId, orderId, info);
        if (res == 1){
            reMap.put("code", 2001);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 2002);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }
        return reMap;
    }



}