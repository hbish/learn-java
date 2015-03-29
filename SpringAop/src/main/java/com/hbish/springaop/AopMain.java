package com.hbish.springaop;

import com.hbish.springaop.service.FactoryService;
import com.hbish.springaop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bshi on 25/03/2015.
 */
public class AopMain {

    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        //ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        FactoryService factoryService = new FactoryService();
        ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
        shapeService.getCircle();
    }
}
