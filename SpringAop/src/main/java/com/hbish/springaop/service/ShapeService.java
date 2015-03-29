package com.hbish.springaop.service;

import com.hbish.springaop.aspect.Loggable;
import com.hbish.springaop.model.Circle;
import com.hbish.springaop.model.Triangle;

/**
 * Created by bshi on 25/03/2015.
 */
public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    @Loggable
    public Circle getCircle() {
        System.out.println("getting circle");
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

}
