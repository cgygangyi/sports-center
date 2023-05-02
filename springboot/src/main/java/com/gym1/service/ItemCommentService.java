package com.gym1.service;


import com.gym1.entity.Comment;
import com.gym1.entity.ItemComment;
import com.gym1.entity.ItemOrder;
import com.gym1.mapper.ItemCommentMapper;
import com.gym1.mapper.ItemMapper;
import com.gym1.mapper.ItemOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;



@Service
public class ItemCommentService {

    @Autowired
    ItemCommentMapper itemCommentMapper;

    @Autowired
    ItemOrderMapper itemOrderMapper;

    public int makeItemComment(int userId, int itemOrderId, String info){

        int itemId = itemOrderMapper.queryItemIdByOrderId(itemOrderId);
        Date date = new Date(System.currentTimeMillis());
        ItemComment itemComment = new ItemComment(date, info, userId, itemOrderId, itemId);
        int res = 0;
        try{
            res = itemOrderMapper.editItemOrderCommentState(itemOrderId, 1);
            if (res == 0){
                return res;
            }else{
                try{
                    res = itemCommentMapper.addItemComment(itemComment);
                    return res;
                }catch (Exception e1){
                    itemOrderMapper.editItemOrderCommentState(itemOrderId, 0);
                    return -1;
                }
            }
        }catch (Exception e){
            res = -1;
            return res;
        }


    }

}
