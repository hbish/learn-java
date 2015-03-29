package com.hbish.springaop.service;

import com.hbish.springaop.aspect.LoggingAspect;
import com.hbish.springaop.model.Circle;

/**
 * Created by bshi on 28/03/2015.
 */
public class ShapeServiceProxy extends ShapeService {

    @Override
    public Circle getCircle() {
        new LoggingAspect().loggingAdvice();
        return super.getCircle();
    }
}
