package com.gym1.controller;

import com.gym1.service.VenueStateService;
import com.gym1.service.VenueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/venueType")
public class VenueTypeController {

    @Autowired
    private VenueTypeService venueTypeService;




}
