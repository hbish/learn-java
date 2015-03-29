package com.hbish.springaop.aspect;

import com.hbish.springaop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by bshi on 26/03/2015.
 */
@Aspect
public class LoggingAspect {

    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        Object returnValue = null;

        try {
            System.out.println("before around advice");
            returnValue = proceedingJoinPoint.proceed();
            System.out.println("after around advice");
        } catch (Throwable throwable) {
            System.out.println("throwing");
        }

        System.out.println("after finally");
        return returnValue;
    }

    public void loggingAdvice() {
        System.out.println("logging advice called");
    }

}
