package com.gym1.controller;
import com.gym1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;



@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem/")
    public Map<String, Object> addItem(@RequestBody Map map){

        String name = map.get("name").toString();
        String info = map.get("info").toString();
        double price = Double.parseDouble(map.get("price").toString());
        System.out.println(map.get("image"));
        Map<String, Object> reMap = new HashMap<>();
        return reMap;

    }

}
