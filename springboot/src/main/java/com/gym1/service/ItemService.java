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
        List<Item> res = itemMapper.queryAllItem();
        for (Item re : res) {
            re.setImage("data:image/png;base64," + re.getImage());
        }
        return res;
    }

}
