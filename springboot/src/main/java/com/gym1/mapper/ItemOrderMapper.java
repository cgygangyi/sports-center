package com.gym1.mapper;
import com.gym1.entity.ItemOrder;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ItemOrderMapper {

    int addItemOrder(ItemOrder itemOrder);

    int queryItemIdByOrderId(int id);

    int editItemOrderCommentState(int orderId, int state);

}
