package com.gym1.controller;
import com.gym1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



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
                                       @RequestParam("price") double price){
        try {
            byte[] byteImage = image.getBytes();
            System.out.println(image.getBytes());
            Map<String, Object> reMap = new HashMap<>();
            return reMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
