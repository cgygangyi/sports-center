package com.gym1.service;
import com.gym1.entity.Comment;
import com.gym1.mapper.CommentMapper;
import com.gym1.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;



@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private OrderMapper orderMapper;

    public int makeComment(int userId, int orderId, String info){
        int venueId = orderMapper.queryVenueIdByOrderId(orderId);
        Date date = new Date(System.currentTimeMillis());
        Comment comment = new Comment(userId, orderId, venueId, date, info);
        return commentMapper.addComment(comment);
    }

}
