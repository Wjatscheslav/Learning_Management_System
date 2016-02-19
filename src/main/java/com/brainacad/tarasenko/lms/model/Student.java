package com.brainacad.tarasenko.lms.model;

import java.io.Serializable;
import java.util.*;

/**
 * Created by user on 10.01.2016.
 */
public class Student implements Serializable{
    private final static long serialVersionUID = 2L;
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Map<Task,Integer> notes = new TreeMap<>();
    private Set<Integer> courseIdSet = new TreeSet<>();

    @Override
    public String toString() {
        return String.format("\nStudent ID: %d\nName: %s %s\nAge: %d\nCourse(s): %s", id, firstName, lastName, age, courseIdSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        if (!getFirstName().equals(student.getFirstName())) return false;
        return getLastName().equals(student.getLastName());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
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

    public Map<Task, Integer> getNotes() {
        return notes;
    }

    public void setNotes(Map<Task, Integer> notes) {
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Set<Integer> getCourseIdSet() {
        return courseIdSet;
    }

    public void setCourseIdSet(Set<Integer> courseIdSet) {
        this.courseIdSet = courseIdSet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
