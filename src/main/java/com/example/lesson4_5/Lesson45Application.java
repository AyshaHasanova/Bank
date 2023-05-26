package com.example.lesson4_5;

import com.example.lesson4_5.service.CardService;
import com.example.lesson4_5.service.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Lesson45Application {

    public static void main(String[] args) {

        SpringApplication.run(Lesson45Application.class, args);

        new Test().createCard();
    }

}
