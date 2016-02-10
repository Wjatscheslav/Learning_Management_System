 package com.brainacad.project;

import java.util.*;
import java.util.regex.Pattern;

 /**
 * Created by user on 04.02.2016.
 */
public class Course {
    public enum DaysOfWeek{
        Mon,
        Tue,
        Wed,
        Thu,
        Fri,
        Sat,
        Sun;
    }
    private static int numberOfCourses = 0;
    private String courseName;
    private int courseId;
    private String description;
    private int[] studentsIDsArray;
    private int trainerIdOnThisCourse;
    private Calendar startDate = new GregorianCalendar();
    private Calendar finishDate = new GregorianCalendar();
    private Set<DaysOfWeek> courseDaysSet = new HashSet<>();
    private static Map<Integer,Course> courseMap = new HashMap<>();

    public Course(String courseName, String description, Calendar startDate, Calendar finishDate, Set<DaysOfWeek> days) {
        this.courseName = courseName;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.courseDaysSet = days;
        this.courseId = numberOfCourses;
    }

     @Override
     public String toString() {
         return "Course ID: " + courseId +
                 "\nCourse name: " + courseName +
                 "\nCourse description: " + description +
                 "\nStart date: " + startDate.get(Calendar.DATE) + "." + (startDate.get(Calendar.MONTH) + 1) + "." + startDate.get(Calendar.YEAR) +
                 "\nEnd date: " + finishDate.get(Calendar.DATE) + "." + (finishDate.get(Calendar.MONTH) + 1) + "." + finishDate.get(Calendar.YEAR) +
                 "\nDays: " + courseDaysSet;
     }

     public static void createCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Course name:");
            String name = sc.nextLine();
        System.out.println("Course description:");
            String description = sc.nextLine();
        System.out.println("Start date:");
            Calendar start = Course.checkDate(sc.nextLine());
        while (start == null){
            System.out.println("Invalid date! Try again. (example: 21.10.2013 or 03.05.2014) ");
            start = Course.checkDate(sc.nextLine());
        }
        System.out.println("End date:");
            Calendar end = Course.checkDate(sc.nextLine());
        while (end == null){
            System.out.println("Invalid date! Try again. (example: 21.10.2013 or 03.05.2014) ");
            end = Course.checkDate(sc.nextLine());
        }
        System.out.println("Days:");
            Set<DaysOfWeek> days = Course.checkDayOfWeek(sc.nextLine());
        while (days.isEmpty()){
            System.out.println("Invalid input! Try again. (example: Mon Wed Sat)");
            days = Course.checkDayOfWeek(sc.nextLine());
        }
         numberOfCourses++;
        Course course = new Course(name, description, start, end, days);
        System.out.println("New course has been successfully created!\n");
        System.out.println(course.toString());
        courseMap.put(numberOfCourses,course);
    }


    public static Course getCourse(int key){
        return courseMap.get(key);
    }

//    public void addStudentToCourse(String name,String surname){
//        Student.addStudent(name,surname);
//    }
//
//    public void addTrainerToCourse(String name,String surname){
//        if (trainerIdOnThisCourse != 0) {
//            Trainer.addTrainer(name, surname);
//        }
//    }

     private static Calendar checkDate (String date) {
         Pattern datePattern = Pattern.compile("^(((0?[1-9])|([1,2][0-9])|(3[0,1]))[\\.,-]((0?[1,3-9])|(1[0-2]))[\\.,-](20[0-9][0-9]))|" + //for every month except February
                 "(((0?[1-9])|(1[0-9])|(2[0-8]))[\\.,-](0?2)[\\.,-](20[0-9][0-9]))|" + //for February (not leap year)
                 "((0?[1-9])|(1[0-9])|(2[0-9]))[\\.,-](0?2)[\\.,-]((20[0,2,4,6,8][0,4,8])|(20[1,3,5,7,9][2,6]))$"); //for February (leap year)
         if (datePattern.matcher(date).matches()) {
             Scanner sc = new Scanner(date).useDelimiter("\\.");
             int dayC = sc.nextInt();
             int monthC = (sc.nextInt() - 1);
             int yearC = sc.nextInt();
             return new GregorianCalendar(yearC, monthC, dayC);
         } else {
             return null;
         }
     }

     private static Set<DaysOfWeek> checkDayOfWeek (String days){
         Set<DaysOfWeek> daysOfWeekSet = new HashSet<>();
         Scanner sc = new Scanner(days).useDelimiter(" ");
         String dayName;
         while (sc.hasNext()){
             dayName = sc.next();
             for (DaysOfWeek day : DaysOfWeek.values()){
                 if (dayName.equalsIgnoreCase(day.name())){
                     daysOfWeekSet.add(day);
                 }
             }
         }
         return daysOfWeekSet;
     }

     private int getCourseId() {
         return courseId;
     }

     private String getCourseName() {
         return courseName;
     }

     public static void printAllCourses(){
         for (Course course : courseMap.values()) {
             System.out.println(new StringBuilder("\n").append(course.getCourseId()).append(": ").append(course.getCourseName()).toString());
         }
     }
}
