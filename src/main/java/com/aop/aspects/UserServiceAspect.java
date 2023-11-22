package com.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

    @Before("execution(* com.aop.service.UserService.*(..))")
    public void BeforeService() {
        System.out.println("Before Service");
    }

    @After("execution(* com.aop.service.UserService.*(..))")
    public void AfterService() {
        System.out.println("After Service");
    }

    @AfterThrowing(pointcut = "execution(* com.aop.service.UserService.*(..))", throwing = "e")
    public void AfterException(JoinPoint joinPoint, Exception e) {
        System.out.println("JointPoint : " + joinPoint);
        System.out.println("AfterThrowing exception" + e);
    }

}
