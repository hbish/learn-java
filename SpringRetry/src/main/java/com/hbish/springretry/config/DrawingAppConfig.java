package com.hbish.springretry.config;

import com.hbish.springretry.DrawingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created by bshi on 31/03/2015.
 */
@Configuration
@EnableRetry
public class DrawingAppConfig {

    @Bean
    public DrawingService drawingService() {
        DrawingService ds = new DrawingService();
        ds.setMessage("Test");
        return ds;
    }

}
