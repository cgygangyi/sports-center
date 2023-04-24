package com.gym1.mapper;
import com.gym1.entity.Item;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ItemMapper {

    int addItem(Item item);


}
