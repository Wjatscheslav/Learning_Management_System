package com.brainacad.manager;

import com.brainacad.model.Course;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by user on 11.02.2016.
 */
public class CourseManager {

    private static Map<Integer,Course> courseMap = new HashMap<>();
    private static int numberOfCourses = 0;
    private static Pattern datePattern = Pattern.compile("^(((0?[1-9])|([1,2][0-9])|(3[0,1]))[\\.,-]((0?[1,3,5,7,8])|(1[0,2]))[\\.,-](20[0-9][0-9]))|" + //for month's with 31 day
            "(((0?[1-9])|([1,2][0-9])|(30))[\\.,-]((0?[4,6,9])|(11))[\\.,-](20[0-9][0-9]))|" + //for month's with 30 days
            "(((0?[1-9])|(1[0-9])|(2[0-8]))[\\.,-](0?2)[\\.,-](20[0-9][0-9]))|" + //for February (not leap year)
            "((0?[1-9])|(1[0-9])|(2[0-9]))[\\.,-](0?2)[\\.,-]((20[0,2,4,6,8][0,4,8])|(20[1,3,5,7,9][2,6]))$"); //for February (leap year)

    public static void createCourse(){
        Scanner sc = new Scanner(System.in);
        Calendar dateChecker = new GregorianCalendar();
        Set<Course.DaysOfWeek> days = new HashSet<>();
        Course course = new Course();
        numberOfCourses++;

        course.setCourseId(numberOfCourses);
        System.out.println("Course name:");
        course.setCourseName(sc.nextLine());
        System.out.println("Course description:");
        course.setDescription(sc.nextLine());
        System.out.println("Start date:");
        dateChecker = checkDate(sc.nextLine());
        while (dateChecker == null){
            System.out.println("Invalid date! Try again. (example: 21.10.2013 or 03.05.2014) ");
            dateChecker = checkDate(sc.nextLine());
        }
        course.setStartDate(dateChecker);
        System.out.println("End date:");
        dateChecker = checkDate(sc.nextLine());
        while (dateChecker == null){
            System.out.println("Invalid date! Try again. (example: 21.10.2013 or 03.05.2014) ");
            dateChecker = checkDate(sc.nextLine());
        }
        course.setFinishDate(dateChecker);
        System.out.println("Days:");
        days = checkDayOfWeek(sc.nextLine());
        while (days.isEmpty()){
            System.out.println("Invalid input! Try again. (example: Mon Wed Sat)");
            days = checkDayOfWeek(sc.nextLine());
        }
        course.setCourseDaysSet(days);
        System.out.println("New course has been successfully created!\n");
        System.out.println(course.toString());
        courseMap.put(numberOfCourses,course);
    }


    private static Set<Course.DaysOfWeek> checkDayOfWeek (String days){
        Set<Course.DaysOfWeek> daysOfWeekSet = new HashSet<>();
        Scanner sc = new Scanner(days).useDelimiter(" ");
        String dayName;
        while (sc.hasNext()){
            dayName = sc.next();
            for (Course.DaysOfWeek day : Course.DaysOfWeek.values()){
                if (dayName.equalsIgnoreCase(day.name())){
                    daysOfWeekSet.add(day);
                }
            }
        }
        return daysOfWeekSet;
    }

    private static Calendar checkDate(String date) {
        Scanner sc = new Scanner(date);
        if (datePattern.matcher(date).matches()) {
            sc.useDelimiter("\\.");
            int dayC = sc.nextInt();
            int monthC = (sc.nextInt() - 1);
            int yearC = sc.nextInt();
            return new GregorianCalendar(yearC, monthC, dayC);
        } else {
            return null;
        }
    }

    public static void setCourse(Course course){
        numberOfCourses++;
        courseMap.put(numberOfCourses,course);
    }

    public static Course getCourse(int id){
        if (courseMap.containsKey(id)){
            return courseMap.get(id);
        } else {
            throw new NoSuchElementException("Course with id " + id + " doesn't exist." );
        }
    }

    public static Map<Integer, Course> getCourseMap() {
        return courseMap;
    }

    public static void printAllCourses(Set<Integer> courseIdSet){
        System.out.println();
        for (Course course : courseMap.values()){
            if(courseIdSet.contains(course.getId())){
                System.out.println(course.getId() + ": " + course.getName());
            }
        }
    }

    public static void printAllCourses(){
        System.out.println();
        for (Course course : courseMap.values()){
            System.out.println(course.getId() + ": " + course.getName());
        }
    }

}
