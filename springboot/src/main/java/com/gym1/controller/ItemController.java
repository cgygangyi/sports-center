package com.gym1.controller;
import com.gym1.service.ItemService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public Map<String, Object> addItem(@RequestParam("image") MultipartFile image,
                                       @RequestParam("name") String name,
                                       @RequestParam("info") String info,
                                       @RequestParam("price") double price) throws IOException{
        Map<String, Object> reMap = new HashMap<>();
        BASE64Encoder encoder = new BASE64Encoder();
        String baseStr= encoder.encode(image.getBytes());
        baseStr = baseStr.replaceAll("\r\n", "");
        System.out.println(baseStr);
        boolean res = itemService.addItem(name, info, price, baseStr);
        if (res){
            reMap.put("code", 3001);
            reMap.put("msg", "Success!");
            reMap.put("data", res);
        }else{
            reMap.put("code", 3002);
            reMap.put("msg", "This item has existed!");
            reMap.put("data", res);
        }
        return reMap;
    }

    @GetMapping("/getAllItem")
    public Map<String, Object> getAllItem(){
        Map<String, Object> reMap = new HashMap<>();
        reMap.put("code", 3003);
        reMap.put("msg", "Success!");
        reMap.put("data", itemService.getAllItem());
        return reMap;
    }


}
