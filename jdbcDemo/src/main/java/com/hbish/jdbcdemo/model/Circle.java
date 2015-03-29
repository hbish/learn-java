package com.hbish.jdbcdemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by bshi on 28/03/2015.
 */
@Entity
public class Circle {

    @Id
    private int id;
    private String name;

    public Circle(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Circle() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
