package com.gym1.controller;

import com.gym1.entity.ItemOrder;
import com.gym1.service.ItemOrderService;
import com.gym1.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;



@RestController
@CrossOrigin
@RequestMapping("/itemOrder")
public class ItemOrderController {

    @Autowired
    ItemOrderService itemOrderService;

    @PostMapping("/makeOrder/{itemId}")
    public Map<String, Object> makeOrder(HttpServletRequest request, @PathVariable int itemId,
                                         @RequestBody Map map){
        Map<String, Object> reMap = new HashMap<>();
        int res = itemOrderService.makeOrder(itemId, JwtUtil.getMemberIdByJwtToken(request), map);
        if (res == -1){
            reMap.put("code", 1001);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if (res == 0){
            reMap.put("code", 1001);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 1001);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }




}