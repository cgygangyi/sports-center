package com.gym1.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



public class ItemOrder {

    private int id;
    private int userId;
    private int itemId;
    private int number;
    private double price;
    private String username;
    private String name;
    private String phoneNum;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date orderTime;


}
