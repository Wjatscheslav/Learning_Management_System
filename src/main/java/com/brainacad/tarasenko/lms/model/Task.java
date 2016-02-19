package com.brainacad.tarasenko.lms.model;

import java.io.Serializable;

/**
 * Created by user on 18.01.2016.
 */
public class Task implements Serializable{

    private final static long serialVersionUID = 4L;

    private long id;
    private String name;
    private String text;


    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
