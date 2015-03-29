package com.hbish.springdemo.test;

import java.util.List;

/**
 * Created by bshi on 21/03/2015.
 */
public class Triangle implements Shape{

    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void draw() {
        System.out.println("triangle");
        for (Point p:getPoints()){
            System.out.println(p.getX() + ", " + p.getY());
        }
    }
}
