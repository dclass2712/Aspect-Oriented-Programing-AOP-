package com.aop.service;

import com.aop.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    User user;

    public List<User> createUser(){
        List<User> users = new ArrayList<>();
        users.add(new User("1001","abc","USA"));
        users.add(new User("1002","xyz","UAE"));
        return users;
    }

    public User getUserById(String id){
        List<User> users = this.createUser();
        for(User user : users){
            if(user.getUserId().equals(id)){
                return user;
            }
        }
        if(user == null){
            throw new NullPointerException("User Not Found for Id: "+id);
        } else {
            throw new RuntimeException("Unexpected Error");
        }
    }

}
