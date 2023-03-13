package com.gym1.entity;

public class User {

    private int id;
    private int sex;
    private int age;
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;


    public User(int id, String username, String password, int sex, String name,
                String phoneNumber, String email, int age){
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public int getId(){ return this.id;}
    public int getSex(){ return this.sex;}
    public int getAge() { return this.age;}
    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}
    public String getName() {return this.name;}
    public String getEmail() {return this.email;}
    public String getPhoneNumber() {return this.phoneNumber;}


    public void setSex(int sex) { this.sex = sex;}
    public void setAge(int age) {this.age = age;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}


    @Override
    public String toString(){
        return "Student{" +
                "id='" + id + '\'' +
                "sex=" + sex +
    }


}
