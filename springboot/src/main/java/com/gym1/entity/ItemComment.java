package com.gym1.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



public class ItemComment {

    private int id;
    private int userId;
    private int orderId;
    private int itemId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date commentTime;
    private String username;
    private String info;


    public ItemComment(int id, int userId, int orderId, int itemId, Date commentTime,
                       String username, String info) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.itemId = itemId;
        this.commentTime = commentTime;
        this.username = username;
        this.info = info;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public Date getCommentTime() {
        return commentTime;
    }
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemComment)) return false;
        ItemComment that = (ItemComment) o;
        if (getId() != that.getId()) return false;
        if (getUserId() != that.getUserId()) return false;
        if (getOrderId() != that.getOrderId()) return false;
        if (getItemId() != that.getItemId()) return false;
        if (getCommentTime() != null ? !getCommentTime().equals(that.getCommentTime()) : that.getCommentTime() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
            return false;
        return getInfo() != null ? getInfo().equals(that.getInfo()) : that.getInfo() == null;
    }
    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUserId();
        result = 31 * result + getOrderId();
        result = 31 * result + getItemId();
        result = 31 * result + (getCommentTime() != null ? getCommentTime().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getInfo() != null ? getInfo().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "ItemComment{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                ", commentTime=" + commentTime +
                ", username='" + username + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
