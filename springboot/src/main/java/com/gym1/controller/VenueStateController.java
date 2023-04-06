package com.gym1.controller;

import com.gym1.entity.VenueState;
import com.gym1.service.VenueStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@CrossOrigin
@RequestMapping("/venueState")
public class VenueStateController {

    @Autowired
    private VenueStateService venueStateService;

    @GetMapping("/getTime/{id}")
    public List<VenueState> getTime(@PathVariable int id){
        return venueStateService.getPotentialState(id);
    }
    @GetMapping("/getAll")
    public List<VenueState> getAll(){
        return venueStateService.getAllVenueState();
    }


}
