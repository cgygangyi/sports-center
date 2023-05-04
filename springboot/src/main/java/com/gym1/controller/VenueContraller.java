package com.gym1.controller;


import com.gym1.entity.Venue;
import com.gym1.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@CrossOrigin
@RequestMapping("/venue")
public class VenueContraller {

    @Autowired
    private VenueService venueService;

    @GetMapping("/getAll")
    public List<Venue> getAll(){
        return venueService.getAllVenue();
    }

    @GetMapping("/getVenueInfo/{venueId}")
    public Map<String, Object> getVenueInfo(@PathVariable int venueId){
        Map<String, Object> reMap = new HashMap<>();
        Venue res = venueService.getVenueInfo(venueId);
        reMap.put("code", 5001);
        reMap.put("msg", "Success!");
        reMap.put("data", res);
        return reMap;
    }


}
