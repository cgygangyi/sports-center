package com.gym1.controller;
import com.gym1.entity.Order;
import com.gym1.service.OrderService;
import com.gym1.service.VenueTypeService;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkOrder/{id}")
    public Map<String, Object> checkOrder(@PathVariable int id){
        List<Order> order = orderService.queryUserOrder(id);
        Map<String, Object> reMap = new HashMap<>();
        if (order.size() == 0){
            reMap.put("code", 3001);
            reMap.put("message", "You didn't make any order!");
            reMap.put("data", order);
        }else{
            reMap.put("code", 3002);
            reMap.put("message", "Success!");
            reMap.put("data", order);
        }
        return reMap;
    }

    @PostMapping("/makeOrder")
    public Map<String, Object> login(HttpServletRequest request, @RequestBody Map map){
        Map<String, Object> reMap = new HashMap<>();
        System.out.println(JwtUtil.getMemberIdByJwtToken(request));
        boolean res = orderService.addOrder(map, JwtUtil.getMemberIdByJwtToken(request));
        if(!res){
            reMap.put("code", 3011);
            reMap.put("message", "Failure!");
            reMap.put("data", false);
        }else{
            reMap.put("code", 3012);
            reMap.put("message", "Success!");
            reMap.put("data", true);
        }
        return reMap;
    }

}
