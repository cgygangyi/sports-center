package com.gym1.controller;


import com.gym1.entity.Order;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/makeOrder/{venueStateId}")
    public Map<String, Object> makeOrder(HttpServletRequest request, @PathVariable int venueStateId){
        Map<String, Object> reMap = new HashMap<>();
        int res = orderService.addOrder(venueStateId, JwtUtil.getMemberIdByJwtToken(request));
        if(res == -2){
            reMap.put("code", 5001);
            reMap.put("message", "Failure!");
            reMap.put("data", res);
        }else if(res == -1){
            reMap.put("code", 5002);
            reMap.put("message", "Error!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 5003);
            reMap.put("message", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @GetMapping("/getAllOrder")
    public Map<String, Object> getAllOrder(HttpServletRequest request){
        Map<String, Object> reMap = new HashMap<>();
        int uId = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        List<Order> res = orderService.queryUserOrder(uId);
        if (res.size() != 0){
            reMap.put("code", 5004);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 5005);
            reMap.put("msg", "There are no orders!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @GetMapping("/getAllUncommentOrder")
    public Map<String, Object> getAllUncommentOrder(HttpServletRequest request){
        Map<String, Object> reMap = new HashMap<>();
        int uId = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        List<Order> res = orderService.queryUserUncommentOrder(uId);
        if (res.size() != 0){
            reMap.put("code", 5006);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 5007);
            reMap.put("msg", "There are no orders!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @PostMapping("/deleteOrder/{id}")
    public Map<String, Object> deleteOrder(@PathVariable int id){
        Map<String, Object> reMap = new HashMap<>();
        int res = orderService.deleteOrder(id);
        if (res == -1){
            reMap.put("code", 5008);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if (res == 0){
            reMap.put("code", 5009);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 5010);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }

}
