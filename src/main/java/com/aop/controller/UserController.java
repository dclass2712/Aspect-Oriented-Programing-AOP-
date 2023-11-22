package com.aop.controller;

import com.aop.entity.User;
import com.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/getUser")
//    public ResponseEntity<User> getUser(@RequestParam String id){
//        User user = new User("1001","Demo","USA");
//        if((user.getUserId()).equals(id)){
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else{
//            try {
//                throw new RuntimeException("UserId not Found");
//            }catch (Exception e){
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        }
//    }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@Validated @RequestParam String id){
        try{
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
