package com.brainacad.project;

/**
 * Created by user on 04.02.2016.
 */
public class Person {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
