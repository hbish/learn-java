package com.hbish.springaop.service;

import com.hbish.springaop.model.Circle;
import com.hbish.springaop.model.Triangle;

/**
 * Created by bshi on 28/03/2015.
 */
public class FactoryService {

    public Object getBean(String beanType) {
        if (beanType.equals("shapeService")) return new ShapeServiceProxy();
        if (beanType.equals("circle")) return new Circle();
        if (beanType.equals("triangle")) return new Triangle();
        return null;
    }

}
