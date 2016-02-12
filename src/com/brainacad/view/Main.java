package com.brainacad.view;

import com.brainacad.fileoperations.FileManager;
import com.brainacad.manager.CourseManager;
import com.brainacad.manager.StudentManager;
import com.brainacad.model.Course;
import com.brainacad.model.Student;
import com.brainacad.model.Trainer;

import java.util.*;

/**
 * Created by user on 10.01.2016.
 */
public class Main {
    public static void main(String[] args){
 //       Scanner sc = new Scanner(System.in);


        FileManager.readFromFile();
        System.out.println("Courses count " + CourseManager.getCourseMap().size());
        System.out.println("Students count " + StudentManager.getStudentMap().size());
        System.out.println(CourseManager.getCourse(1));
        System.out.println(StudentManager.getStudent(1));
        CourseManager.printAllCourses();

//        CourseManager.createCourse();
//        StudentManager.createStudent();
//        FileManager.writeToFile();

    }
}
