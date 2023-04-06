package com.gym1.controller;
import com.gym1.service.VenueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private VenueTypeService venueTypeService;

}
