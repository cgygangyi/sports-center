package com.gym1.mapper;
import com.gym1.entity.ItemComment;
import com.gym1.entity.ItemOrder;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ItemCommentMapper {

    int addItemComment(ItemComment itemComment);


}
