package com.brainacad.view;

import com.brainacad.project.Course;
import com.brainacad.project.Student;
import com.brainacad.project.Trainer;

import java.util.*;

/**
 * Created by user on 10.01.2016.
 */
public class Main {
    public static void main(String[] args){
//        Student.addStudent("Viacheslav","Tarasenko");
//        Student.addStudent("Vladimir","Fastovez");
//        Student.addStudent("Konstantin","Kalinovskiy");
//        Student.addStudent("Andrey","Denisov");
//        Student.addStudent("Viacheslav","Evlahov");
//        Student.addStudent("Oleksii","Karpenko");
        Student student1 = new Student("Viacheslav","Tarasenko");
        System.out.println(Student.getStudent(0));
        Student.createStudent();
        System.out.println(Student.getStudent(1));
        Trainer.addTrainer("Alexander","Semeniuk");
        Set<Course.DaysOfWeek> days = new HashSet<>();
        days.add(Course.DaysOfWeek.Mon);
//        Course.createCourse();
//        Course.createCourse();
//        Course.printAllCourses();
    }
}
