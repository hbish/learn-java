package com.hbish.jdbcdemo.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by bshi on 29/03/2015.
 */
public class NamedJdbcDaoImpl extends NamedParameterJdbcDaoSupport {

    public int getCircleCount() {
        String sql = "select COUNT(*) from circle";
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }

}
