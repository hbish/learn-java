package com.hbish.springretry;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.Mockito.*;


/**
 * Created by bshi on 31/03/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class DrawingAppTest {

    @Autowired
    private DrawingService drawingService;

    @Test
    public void testDrawRetry() throws Exception {

        // No retry, called once
        doNothing().when(drawingService).draw();
        drawingService.draw();

        reset(drawingService);

        // Retry will kick in, called 3 times in total here
        doThrow(new RuntimeException("E1")).doThrow(new RuntimeException("E2")).doNothing().when(drawingService).draw();
        drawingService.draw();

        // Verify total 4 tries
        verify(drawingService, times(4)).draw();
    }

    @EnableRetry
    @Configuration
    @EnableAspectJAutoProxy(proxyTargetClass = true)
    static class ContextConfiguration {
        @Bean
        public DrawingService drawingService() {
            DrawingService ds = mock(DrawingService.class);
            ds.setMessage("unit test");
            return ds;
        }
    }

}
