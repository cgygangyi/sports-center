package com.gym1.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Comment {

    private int id;
    private int userId;
    private int orderId;
    private int venueId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date commentTime;
    private String username;
    private String info;

    public Comment(int userId, int orderId, int venueId, Date commentTime, String info){
        this.userId = userId;
        this.venueId = venueId;
        this.orderId = orderId;
        this.commentTime = commentTime;
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
    public int getVenueId() {
        return venueId;
    }
    public void setVenueId(int venueId) {
        this.venueId = venueId;
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
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        if (getId() != comment.getId()) return false;
        if (getUserId() != comment.getUserId()) return false;
        if (getOrderId() != comment.getOrderId()) return false;
        if (getVenueId() != comment.getVenueId()) return false;
        if (getCommentTime() != null ? !getCommentTime().equals(comment.getCommentTime()) : comment.getCommentTime() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(comment.getUsername()) : comment.getUsername() != null)
            return false;
        return getInfo() != null ? getInfo().equals(comment.getInfo()) : comment.getInfo() == null;
    }
    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUserId();
        result = 31 * result + getOrderId();
        result = 31 * result + getVenueId();
        result = 31 * result + (getCommentTime() != null ? getCommentTime().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getInfo() != null ? getInfo().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", venueId=" + venueId +
                ", commentTime=" + commentTime +
                ", username='" + username + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
