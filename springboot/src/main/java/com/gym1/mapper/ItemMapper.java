package com.gym1.mapper;
import com.gym1.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface ItemMapper {

    void addItem(Item item);

    List<Item> queryItemByName(String name);

    List<Item> queryAllItem();

    void deleteItemByName(String name);

    List<Item> queryItemById(int id);

}
