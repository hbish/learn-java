package com.hbish.springdemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bshi on 21/03/2015.
 */
public class DrawingApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        context.registerShutdownHook();
        Shape shape = (Shape) context.getBean("circle");

        shape.draw();
    }
}
