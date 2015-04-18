package com.hbish.springretry;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by bshi on 31/03/2015.
 */
@Service
public class DrawingService {

    private String message;

    public DrawingService() {
    }

    @Retryable
    public void draw() {
        System.out.println("Drawing...." + getMessage());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
