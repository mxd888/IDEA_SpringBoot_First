package com.ssm.crud.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userPass;
    private String userEmail;
    private String userAddr;

//    public User(String userName, String userPass, String userEmail, String userAddr) {
//        this.userName = userName;
//        this.userPass = userPass;
//        this.userEmail = userEmail;
//        this.userAddr = userAddr;
//    }

    public User() {
    }

    public User(Integer userId, String userName, String userPass, String userEmail, String userAddr) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userAddr = userAddr;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddr='" + userAddr + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }
}
