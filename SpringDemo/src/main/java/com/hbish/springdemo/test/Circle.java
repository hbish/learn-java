package com.hbish.springdemo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by bshi on 22/03/2015.
 */
@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

    @Resource
    private Point center;

    @Autowired
    private MessageSource messageSource;

    private ApplicationEventPublisher publisher;

    @Override
    public void draw() {
        System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Greeting", null));
        System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default Greeting", null));
        publisher.publishEvent(new DrawEvent(this));
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void initializeCircle() {
        System.out.println("init circle");
    }

    @PreDestroy
    public void destoryCircle() {
        System.out.println("destory circle");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
