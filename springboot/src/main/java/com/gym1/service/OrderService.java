package com.gym1.service;
import com.gym1.mapper.OrderMapper;
import com.gym1.mapper.VenueStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderService {

    @Autowired
    private VenueStateMapper venueStateMapper;

    @Autowired
    private OrderMapper orderMapper;




}
