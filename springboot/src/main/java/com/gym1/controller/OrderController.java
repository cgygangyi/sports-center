package com.gym1.controller;
import com.gym1.entity.VenueState;
import com.gym1.service.VenueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private VenueTypeService venueTypeService;

}
