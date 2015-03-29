package com.hbish.jdbcdemo.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by bshi on 29/03/2015.
 */
@Repository
public class HibernateDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public Long getCircleCount() {
        String hql = "select count(*) from Circle";
        Query query = getSessionFactory().openSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
