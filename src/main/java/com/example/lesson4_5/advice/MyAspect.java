package com.example.lesson4_5.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {
    @Before("execution(* com.example.lesson4_5.service.Test.createCard())")
    public void afterDoSomething(JoinPoint joinPoint) {
        log.info("After doing something called after create card");
        System.out.println("After doing something called after create card");
    }
}
