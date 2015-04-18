package com.hbish.springretry;

import com.hbish.springretry.config.DrawingAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by bshi on 31/03/2015.
 */
public class DrawingApp {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DrawingAppConfig.class);
        DrawingService drawingService = (DrawingService) context.getBean("drawingService");
        drawingService.draw();

    }
}
