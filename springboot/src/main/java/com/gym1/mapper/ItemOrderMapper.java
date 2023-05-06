package com.gym1.mapper;
import com.gym1.entity.ItemOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface ItemOrderMapper {

    int addItemOrder(ItemOrder itemOrder);

    int queryItemIdByOrderId(int id);

    int editItemOrderCommentState(int orderId, int state);

    List<ItemOrder> queryItemOrderByUserId(int id);

    List<ItemOrder> queryItemOrderByUserIdComment(int id);

    int deleteItemOrder(int id);

    List<ItemOrder> queryAllItemOrder();

    ItemOrder queryItemOrderByItemOrderId(int id);

}
