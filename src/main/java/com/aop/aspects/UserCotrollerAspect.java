package com.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserCotrollerAspect {

//    @Around("execution(* com.aop.service.UserServiceAspect.*(..))")
//    public void aroundUserController() {
//        System.out.println("****");
//    }

    @Before("execution(ResponseEntity<User> com.aop.controller.UserController.getUser(..))")
    public void notifyBefore() {
        System.out.println("API process is starting!");
    }

    @After("execution(* com.aop.controller.UserController.*(..))")
    public void notifyAfter() {
        System.out.println("API process is end!");
    }

    @AfterReturning("execution(* com.aop.controller.UserController.*(..))")
    public void AfterReturningRequest(){
        System.out.println("Successfully returning userController");
    }
}
