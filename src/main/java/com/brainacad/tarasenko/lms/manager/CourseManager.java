package com.brainacad.tarasenko.lms.manager;

import com.brainacad.tarasenko.lms.model.Course;
import com.brainacad.tarasenko.lms.util.Checker;

import java.io.*;
import java.util.*;

/**
 * Created by user on 11.02.2016.
 */
public class CourseManager {

    private final static String FILE_PATH = "course.ser";

    private static CourseManager instance = new CourseManager();
    private Map<Integer, Course> courseMap = new HashMap<>();

    private CourseManager() {
    }

    public static CourseManager getInstance() {
        return instance;
    }

    public void createCourse() {
        Checker checker = Checker.getInstance();
        Scanner sc = new Scanner(System.in);
        Date date;
        Set<Course.DaysOfWeek> days;
        Course course = new Course();
        course.setCourseId(courseMap.size() + 1);
        System.out.println("Course name:");
        course.setCourseName(sc.nextLine());
        System.out.println("Course description:");
        course.setDescription(sc.nextLine());
        System.out.println("Start date:");
        date = checker.checkDate(sc.nextLine());
        while (date == null) {
            System.out.println("Invalid date! Try again. (example: 21.10.2013) ");
            date = checker.checkDate(sc.nextLine());
        }
        course.setStartDate(date);
        System.out.println("End date:");
        date = checker.checkDate(sc.nextLine());
        while (date == null) {
            System.out.println("Invalid date! Try again. (example: 21.10.2013) ");
            date = checker.checkDate(sc.nextLine());
        }
        course.setFinishDate(date);
        System.out.println("Days:");
        days = checker.checkDayOfWeek(sc.nextLine());
        while (days.isEmpty()) {
            System.out.println("Invalid input! Try again. (example: Mon Wed Sat)");
            days = checker.checkDayOfWeek(sc.nextLine());
        }
        course.setCourseDaysSet(days);
        System.out.println("New course has been successfully created!\n");
        System.out.println(course.toString());
        courseMap.put(courseMap.size() + 1, course);
    }

    public Course getCourse(int id) {
        if (courseMap.containsKey(id)) {
            return courseMap.get(id);
        } else {
            throw new NoSuchElementException("Course with id " + id + " doesn't exist.");
        }
    }

    public void printStudents(int courseId){
        Set<Integer> studentSet = CourseManager.getInstance().getCourse(courseId).getStudentsSet();
        for (Integer i : studentSet){
            System.out.println(StudentManager.getInstance().getStudent(i));
        }
    }

    public void printAllCourses() {
        System.out.println();
        for (Course course : courseMap.values()) {
            System.out.println(course.getId() + ": " + course.getName());
        }
        System.out.println();
    }

    public boolean isCourseExists(int courseId) {
        return courseMap.containsKey(courseId);
    }

    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeInt(courseMap.size());
            for (Course course : courseMap.values()){
                outputStream.writeObject(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(int courseId, int studentId){
        CourseManager.getInstance().getCourse(courseId).getStudentsSet().add(studentId);
    }

    public void readFromFile(){
        int size = 0;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            size = inputStream.readInt();
            while (size > 0){
                courseMap.put(courseMap.size() + 1, (Course) inputStream.readObject());
                size--;
            }
        } catch (ClassNotFoundException e){
            System.out.println("File is corrupted!");
        } catch (EOFException e){
            System.out.println("File " + FILE_PATH + " is empty!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
