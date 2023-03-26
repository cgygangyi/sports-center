package com.gym1.mapper;

import com.gym1.entity.Order;
import com.gym1.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    int addOrder(Order order);

    int deleteOrder(Order order);

    int editOrder(Order order);

    List<Order> queryUserOrder(User user);

    List<Order> queryAllOrder();


}
