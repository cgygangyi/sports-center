package com.gym1.service;
import com.gym1.entity.Order;
import com.gym1.entity.VenueState;
import com.gym1.mapper.OrderMapper;
import com.gym1.mapper.VenueStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



@Service
public class OrderService {

    @Autowired
    private VenueStateMapper venueStateMapper;

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> queryUserOrder(int id){
        return orderMapper.queryOrderByUserId(id);
    }

    public boolean addOrder(Map<String, Object> map){
        int id = Integer.parseInt(map.get("id").toString());
        VenueState venueState = venueStateMapper.queryVenueStateById(id);
        if(venueState.getOpen() == 1 && venueState.getFree() == 1){
            venueStateMapper.updateVenueStateFree(id, 0);
            Date date = new Date(System.currentTimeMillis());
//            Order order = new Order()
            return true;
        }else{
            return false;
        }

    }




}
