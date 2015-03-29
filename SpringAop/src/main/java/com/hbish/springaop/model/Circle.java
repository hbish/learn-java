package com.hbish.springaop.model;

/**
 * Created by bshi on 25/03/2015.
 */
public class Circle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName called");
        throw(new RuntimeException());
    }

    public String setNameAndReturn(String name) {
        this.name = name;
        System.out.println("setName called");
        return this.name;
    }
}
