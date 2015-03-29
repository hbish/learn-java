package com.hbish.springdemo.test;

import org.springframework.context.ApplicationEvent;

/**
 * Created by bshi on 22/03/2015.
 */
public class DrawEvent extends ApplicationEvent {

    public DrawEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "Draw Event";
    }
}
