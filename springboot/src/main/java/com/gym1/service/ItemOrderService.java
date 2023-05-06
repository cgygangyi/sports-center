package com.gym1.service;


import com.gym1.entity.Item;
import com.gym1.entity.ItemOrder;
import com.gym1.entity.Order;
import com.gym1.entity.User;
import com.gym1.mapper.ItemMapper;
import com.gym1.mapper.ItemOrderMapper;
import com.gym1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ItemOrderService {

    @Autowired
    ItemOrderMapper itemOrderMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    UserMapper userMapper;


    public int makeOrder(int itemId, String userId, Map map){
        int uId = Integer.parseInt(userId);
        Item item = itemMapper.queryItemById(itemId).get(0);
        User user = userMapper.queryUserById(uId);
        double itemPrice = item.getPrice();
        String name = user.getName();
        String phoneNumber = user.getPhoneNumber();
        String username = user.getUsername();
        int number = Integer.parseInt(map.get("number").toString());
        Date date = new Date(System.currentTimeMillis());
        double price = itemPrice * number;
        ItemOrder itemOrder = new ItemOrder(uId, itemId, number, price,
                username, name, phoneNumber, date);
        int res = 0;
        try{
            res = itemOrderMapper.addItemOrder(itemOrder);
        }catch (Exception e){
            res = -1;
        }
        return res;
    }

    public List<ItemOrder> getUserAllOrder(int id){
        return itemOrderMapper.queryItemOrderByUserId(id);
    }

    public List<ItemOrder> getUserUncommentOrder(int id){
        return itemOrderMapper.queryItemOrderByUserIdComment(id);
    }

    public int deleteOrder(int id){
        int res = 0;
        try{
            res = itemOrderMapper.deleteItemOrder(id);
            return res;
        }catch (Exception e){
            return -1;
        }
    }

    public List<ItemOrder> getAll(){
        return itemOrderMapper.queryAllItemOrder();
    }

    public ItemOrder getReceipt(int id){
        return itemOrderMapper.queryItemOrderByItemOrderId(id);
    }

}
