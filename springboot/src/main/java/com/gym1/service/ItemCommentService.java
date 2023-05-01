package com.gym1.service;
import com.gym1.mapper.ItemCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemCommentService {

    @Autowired
    ItemCommentMapper itemCommentMapper;

    public int makeItemComment(int userId, int itemOrderId, String info){

        return 1;


    }

}
