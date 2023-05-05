package com.gym1.controller;


import com.gym1.entity.ItemOrder;
import com.gym1.service.ItemOrderService;
import com.gym1.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
            reMap.put("code", 4001);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if (res == 0){
            reMap.put("code", 4002);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 4003);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @GetMapping("/getAllOrder")
    public Map<String, Object> getAllOrder(HttpServletRequest request){
        Map<String, Object> reMap = new HashMap<>();
        int uId = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        List<ItemOrder> res = itemOrderService.getUserAllOrder(uId);
        if (res.size() != 0){
            reMap.put("code", 4004);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 4005);
            reMap.put("msg", "There are no orders!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @GetMapping("/getAllUncommentOrder")
    public Map<String, Object> getAllUncommentOrder(HttpServletRequest request){
        Map<String, Object> reMap = new HashMap<>();
        int uId = Integer.parseInt(JwtUtil.getMemberIdByJwtToken(request));
        List<ItemOrder> res = itemOrderService.getUserUncommentOrder(uId);
        if (res.size() != 0){
            reMap.put("code", 4006);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 4007);
            reMap.put("msg", "There are no orders!");
            reMap.put("data", res);
        }
        return reMap;
    }


    @PostMapping("/deleteOrder/{id}")
    public Map<String, Object> deleteOrder(@PathVariable int id){
        Map<String, Object> reMap = new HashMap<>();
        int res = itemOrderService.deleteOrder(id);
        if (res == -1){
            reMap.put("code", 4008);
            reMap.put("msg", "Error!");
            reMap.put("data", res);
        }else if (res == 0){
            reMap.put("code", 4009);
            reMap.put("msg", "Failure!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 4010);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }
        return reMap;
    }


}
