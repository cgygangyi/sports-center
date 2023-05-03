package com.gym1.service;
import com.gym1.entity.Item;
import com.gym1.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    public boolean addItem(String name, String info, double price, String image){
        List<Item> temp = itemMapper.queryItemByName(name);
        if (temp.size() != 0){
            return false;
        }else{
            Item item = new Item(name, price, info, image);
            itemMapper.addItem(item);
            return true;
        }
    }

    public List<Item> getAllItem(){
        return itemMapper.queryAllItem();
    }

    public void deleteItem(String name){
        itemMapper.deleteItemByName(name);
    }

    public Item getItemInfo(int id){
        return itemMapper.queryItemById(id).get(0);
    }

}
