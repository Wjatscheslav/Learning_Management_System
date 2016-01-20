package com.brainacad.project;

import java.util.*;

/**
 * Created by user on 10.01.2016.
 */
public class Student {
    private static Integer numberOfStudents = 0;
    private String studentName;
    private String studentSurname;
    private Integer studentId;
    private static Map<Integer,Student> studentMap = new HashMap<>();
    private Map<Task,Integer> notes = new HashMap<>();

    {
        Iterator<Task> i = Task.taskList.iterator();
        while (i.hasNext()){
           this.notes.put(i.next(),0);
        }
    }

    private Student(String name, String surname){
        this.studentName = name;
        this.studentSurname = surname;
        this.studentId = numberOfStudents;
    }

    private String getStudentName() {
        return studentName;
    }

    private String getStudentSurname() {
        return studentSurname;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public static void addStudent(String name, String surname){
        studentMap.put(numberOfStudents,new Student(name,surname));
        numberOfStudents++;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(studentName).append(" ").append(studentSurname).toString();
    }

    public static void printStudents(){
        System.out.println(studentMap);
    }

    public static Student getStudent(Integer key){
        return studentMap.get(key);
    }

    public void doTask(String taskName,int note){
        Iterator<Task> i = Task.taskList.iterator();
        while (i.hasNext()){
            if (i.next().equals(taskName)){
                this.notes.put(new Task(taskName),note);
                System.out.println(taskName);
            }
        }
    }

    public void printNotes(){
//        for (Map.Entry<Task,Integer> n : notes.entrySet() ){
//            System.out.println(new StringBuilder().append("Student ").append(this.studentId).append("\n\t")
//                    .append(n.getKey()).append(" ").append(n.getValue()).toString());
//        }
        System.out.println(notes);
    }
}
