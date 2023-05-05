package com.gym1.controller;


import com.gym1.entity.VenueState;
import com.gym1.service.VenueStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/venueState")
public class VenueStateController {

    @Autowired
    private VenueStateService venueStateService;


    @GetMapping("/admin/getAllTime/{num}")
    public Map<String, Object> getAllTime(@PathVariable int num){
        Map<String, Object> reMap = new HashMap<>();
        List<VenueState> res = venueStateService.getAll(num);
        reMap.put("code", 9001);
        reMap.put("msg", "Success!");
        reMap.put("data", res);
        return reMap;
    }


    @GetMapping("/getTime/{id}")
    public List<VenueState> getTime(@PathVariable int id){
        return venueStateService.getPotentialState(id);
    }

    @GetMapping("/getAll")
    public List<VenueState> getAll(){
        return venueStateService.getAllVenueState();
    }





}
