package com.brainacad.tarasenko.lms.manager;

import com.brainacad.tarasenko.lms.model.Student;
import com.brainacad.tarasenko.lms.util.Checker;

import java.io.*;
import java.util.*;

/**
 * Created by user on 11.02.2016.
 */

public class StudentManager {

    private static final String FILE_PATH = "student.ser";

    private static StudentManager instance = new StudentManager();
    private StudentManager(){}

    private Map<Integer,Student> studentMap = new TreeMap<>();

    public static StudentManager getInstance(){
        return instance;
    }

    public void createStudent(){
        Set<Integer> courseIdSet = new TreeSet<>();
        String courses;
        Scanner sc = new Scanner(System.in);
        Scanner courseScanner;
        int courseId;
        Checker checker = Checker.getInstance();
        Student student = new Student();
        student.setId(studentMap.size() + 1);
        do {
            System.out.println("First name: ");
            student.setFirstName(checker.checkName(sc.next()));
            System.out.println("Last name: ");
            student.setLastName(checker.checkName(sc.next()));
        } while(!isStudentUnique(student));
        System.out.println("Age: ");
        student.setAge(sc.nextInt());
        System.out.println("Course(s): ");
        courses = sc.next();
        courseScanner = new Scanner(courses).useDelimiter(",");
        while (courseScanner.hasNextInt()) {
            courseId = courseScanner.nextInt();
            if (CourseManager.getInstance().isCourseExists(courseId)) {
                courseIdSet.add(courseId);
                CourseManager.getInstance().addStudent(courseId,studentMap.size() + 1);
            } else {
                System.out.println("Course with id " + courseId + " doesn't exist.");
            }
        }
        student.setCourseIdSet(courseIdSet);
        System.out.println("New student has been successfully created!");
        System.out.println(student);
        studentMap.put(studentMap.size() + 1,student);
    }

    private boolean isStudentUnique(Student student){
        boolean b = true;
        for (Student student1 : studentMap.values()){
            if (student.equals(student1)){
                b = !b;
                System.out.println("Student name should be unique");
            }
        }
        return b;
    }

    public Student getStudent(int id){
        if (studentMap.containsKey(id)){
            return studentMap.get(id);
        } else {
            throw new NoSuchElementException("Student with id " + id + " doesn't exist.");
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeInt(studentMap.size());
            for (Student student : studentMap.values()){
                outputStream.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        int size = 0;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            size = inputStream.readInt();
            while (size > 0){
                studentMap.put(studentMap.size() + 1, (Student) inputStream.readObject());
                size--;
            }
        } catch (ClassNotFoundException e){
            System.out.println("File is corrupted");
        } catch (EOFException e){
            System.out.println("File " + FILE_PATH + " is empty!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
