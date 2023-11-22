package com.aop.entity;

import lombok.Data;

@Data
public class User {

    private String userId;
    private String userName;
    private String userAddress;

    public User(String userId, String userName, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
    }
}
