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


    public int addItem(String name, String info, double price, String image){
        List<Item> temp = itemMapper.queryItemByName(name);
        if (temp.size() != 0){
            return -2;
        }else{
            Item item = new Item(name, price, info, image);
            int res = 0;
            try{
                res = itemMapper.addItem(item);
                return res;
            }catch (Exception e){
                return -1;
            }
        }
    }

    public List<Item> getAllItem(){
        return itemMapper.queryAllItem();
    }

    public int deleteItem(int id){
        int res = 0;
        try{
            res = itemMapper.updateItemValidById(id);
            return res;
        }catch (Exception e){
            return -1;
        }
    }

    public Item getItemInfo(int id){
        return itemMapper.queryItemById(id).get(0);
    }

    public int editItem(String name, String info, double price, String image, int itemId){
        int res = 0;
        try{
            if (image.equals("data:image/png;base64,")){
                res = itemMapper.updateItemById2(name, info, price, itemId);
            }else{
                res = itemMapper.updateItemById(name, info, price, image, itemId);
            }
            return res;
        }catch (Exception e){
            return -1;
        }
    }

}
