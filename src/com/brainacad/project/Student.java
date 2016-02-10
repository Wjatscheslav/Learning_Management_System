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

    public Student(String name, String surname){
        super(name,surname);
        this.setId(numberOfStudents);
        studentMap.put(numberOfStudents,this);
        numberOfStudents++;
    }

    public static void createStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("First name:");
        String name = sc.nextLine();
        System.out.println("Last name:");
        String surname = sc.nextLine();
        Student student = new Student(name,surname);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.getFirstName()).append(" ").append(this.getLastName()).toString();
    }

    public static Student getStudent(Integer key){
        return studentMap.get(key);
    }


}
