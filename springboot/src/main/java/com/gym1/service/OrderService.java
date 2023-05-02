package com.gym1.service;


import com.gym1.entity.Order;
import com.gym1.entity.VenueState;
import com.gym1.mapper.OrderMapper;
import com.gym1.mapper.VenueStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    private VenueStateMapper venueStateMapper;

    @Autowired
    private OrderMapper orderMapper;

    public int addOrder(int id, String userId){
        int uId = Integer.parseInt(userId);
        VenueState venueState = venueStateMapper.queryVenueStateById(id);
        if (venueState.getOpen() == 1 && venueState.getFree() == 1){
            int a = 0;
            int b = 0;
            try{
                a = venueStateMapper.updateVenueStateFree(id, 0);
                if (a==0){
                    return -1;
                }else{
                    try{
                        Date date = new Date(System.currentTimeMillis());
                        Order order = new Order(id, uId, date);
                        b = orderMapper.addOrder(order);
                        return b;
                    }catch (Exception e1){
                        venueStateMapper.updateVenueStateFree(id, 1);
                        return -1;
                    }
                }
            }catch (Exception e){
                return -1;
            }
        }else{
            return -2;
        }
    }

    public List<Order> queryUserOrder(int id){
        return orderMapper.queryOrderByUserId(id);
    }

    public List<Order> queryUserUncommentOrder(int id){
        return orderMapper.queryOrderByUserIdComment(id);
    }

    public int deleteOrder(int id){
        int venueStateId = orderMapper.queryVenueStateIdByOrderId(id);
        int a = 0;
        int res = 0;
        try{
            a = venueStateMapper.updateVenueStateFree(venueStateId, 1);
            if (a == 0){
                return 0;
            }else{
                try{
                    res = orderMapper.deleteOrder(id);
                    if (res == 0){
                        venueStateMapper.updateVenueStateFree(venueStateId, 0);
                        return 0;
                    }else{
                        return res;
                    }
                }catch (Exception e){
                    venueStateMapper.updateVenueStateFree(venueStateId, 0);
                    return -1;
                }
            }
        }catch (Exception e){
            return -1;
        }
    }

}
