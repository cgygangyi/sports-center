package com.gym1.controller;


import com.gym1.service.VenueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/venueType")
public class VenueTypeController {

    @Autowired
    private VenueTypeService venueTypeService;


    @GetMapping("/getAll")
    public Map<String, Object> getAll(){
        Map<String, Object> reMap = new HashMap<>();
        List<String> res = venueTypeService.getAll();
        reMap.put("code", 1101);
        reMap.put("msg", "Success!");
        reMap.put("data", res);
        return reMap;
    }


}