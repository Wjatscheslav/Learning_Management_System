package com.brainacad.project;

import java.util.*;

/**
 * Created by user on 10.01.2016.
 */
public class Student extends Person {
    private static Integer numberOfStudents = 0;
    private static Map<Integer,Student> studentMap = new HashMap<>();
    private Map<Task,Integer> notes = new HashMap<>();
    private int[] courseIdArray = new int[10];

    private Student(String name, String surname){
        super(name,surname);
    }

    public static void addStudent(String name, String surname){
        studentMap.put(numberOfStudents,new Student(name,surname));
        numberOfStudents++;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.getFirstName()).append(" ").append(this.getLastName()).toString();
    }


    public static Student getStudent(Integer key){
        return studentMap.get(key);
    }

}
