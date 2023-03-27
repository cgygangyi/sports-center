package com.gym1.controller;
import com.gym1.entity.VenueState;
import com.gym1.service.VenueStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.gym1.entity.User;
import com.gym1.service.UserService;
import com.gym1.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/venueState")
public class VenueStateController {

    @Autowired
    private VenueStateService venueStateService;

    @GetMapping("/getTime/{id}")
    public List<VenueState> getTime(@PathVariable int id){


        List<VenueState> a = venueStateService.getPotentialState(id);
        System.out.println(a);
        return a;

    }


}
