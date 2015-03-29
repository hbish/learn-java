package com.hbish.jdbcdemo;

import com.hbish.jdbcdemo.dao.HibernateDaoImpl;
import com.hbish.jdbcdemo.dao.JdbcDaoImpl;
import com.hbish.jdbcdemo.dao.NamedJdbcDaoImpl;
import com.hbish.jdbcdemo.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bshi on 28/03/2015.
 */
public class jdbcDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

//        dao.insertCircle(new Circle(6, "6th Circle"));

        System.out.println(dao.getCircleCount());
        System.out.println(dao.getCircleName(1));
        System.out.println(dao.getCircleForId(1).toString());
        System.out.println(dao.getCircles());

//        dao.createTriangleTable();

        NamedJdbcDaoImpl namedDao = ctx.getBean("nameJdbcDaoImpl", NamedJdbcDaoImpl.class);
        System.out.println(namedDao.getCircleCount());

        HibernateDaoImpl hibernateDao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
        System.out.println(hibernateDao.getCircleCount());

    }
}
