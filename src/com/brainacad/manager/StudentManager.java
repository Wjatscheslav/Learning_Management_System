package com.brainacad.manager;

import com.brainacad.model.Student;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by user on 11.02.2016.
 */

public class StudentManager {
    private static Integer numberOfStudents = 0;
    private static Map<Integer,Student> studentMap = new HashMap<>();
    private static Pattern namePattern = Pattern.compile("^[A-Z][a-z]+$");

    public static void createStudent(){
        Set<Integer> courseIdSet = new HashSet<>();
        String courses;
        Scanner sc = new Scanner(System.in);
        Scanner courseScanner;
        int courseId;
        Student student = new Student();
        numberOfStudents++;
        student.setId(numberOfStudents);
        do {
            System.out.println("First name: ");
            student.setFirstName(checkName(sc.next()));
            System.out.println("Last name: ");
            student.setLastName(checkName(sc.next()));
        } while(!isStudentUnique(student));
        System.out.println("Age: ");
        student.setAge(sc.nextInt());
        System.out.println("Course(s): ");
        courses = sc.next();
        courseScanner = new Scanner(courses).useDelimiter(",");
        while (courseScanner.hasNextInt()) {
            courseId = courseScanner.nextInt();
            if (CourseManager.getCourseMap().containsKey(courseId)) {
                courseIdSet.add(courseId);
//                CourseManager.getCourse(courseId).addStudentToThisCourse(2);
            } else {
                System.out.println("Course with id " + courseId + " doesn't exist.");
            }
        }
        student.setCourseIdSet(courseIdSet);
        System.out.println("New student has been successfully created!");
        System.out.println(student);
        studentMap.put(numberOfStudents,student);
    }

    private static String checkName(String name) {
        Scanner sc = new Scanner(System.in);
        name = name.toLowerCase();
        name = name.replace(name.charAt(0),(char)(name.charAt(0) - 32));
        if (namePattern.matcher(name).matches()) {
            return name;
        } else {
            System.out.println("Incorrect input! Name must contain only letters. Try again.");
            name = sc.nextLine();
            while (!namePattern.matcher(name).matches()) {
                checkName(name);
            }
            return name;
        }
    }

    private static boolean isStudentUnique(Student student){
        boolean b = true;
        for (Student student1 : studentMap.values()){
            if (student.equals(student1)){
                b = !b;
                System.out.println("Student name should be unique");
            }
        }
        return b;
    }

    public static Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    public static void setStudent(Student student){
        numberOfStudents++;
        studentMap.put(numberOfStudents,student);
    }

    public static Student getStudent(int id){
        if (studentMap.containsKey(id)){
            return studentMap.get(id);
        } else {
            throw new NoSuchElementException("Student with id \" + id + \" doesn't exist.");
        }
    }
}
