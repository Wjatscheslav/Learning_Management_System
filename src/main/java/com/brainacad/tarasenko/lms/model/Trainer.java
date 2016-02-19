package com.brainacad.tarasenko.lms.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 10.01.2016.
 */
public class Trainer implements Serializable{
    private final static long serialVersionUID = 3L;
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Set<Integer> courseIdSet = new TreeSet<>();

    public Trainer() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Integer> getCourseIdSet() {
        return courseIdSet;
    }

    public void setCourseIdSet(Set<Integer> courseIdSet) {
        this.courseIdSet = courseIdSet;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\nTrainer ID: ").append(id).
                append("\nName: ").append(firstName).append(" ").append(lastName).
                append("\nAge: ").append(age).
                append("\nCourse(s): ").append(courseIdSet).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;

        Trainer trainer = (Trainer) o;

        if (!getFirstName().equals(trainer.getFirstName())) return false;
        return getLastName().equals(trainer.getLastName());

    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }
}
