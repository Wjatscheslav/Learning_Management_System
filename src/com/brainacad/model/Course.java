 package com.brainacad.model;

import java.io.Serializable;
import java.util.*;

 /**
 * Created by user on 04.02.2016.
 */
public class Course implements Serializable{
     private final static long serialVersionUID = 1L;
     public enum DaysOfWeek{
         Mon,
         Tue,
         Wed,
         Thu,
         Fri,
         Sat,
         Sun;
     }
     private String courseName;
     private int courseId;
     private String description;
     private Set<Integer> studentsIdSet = new HashSet<>();
     private int trainerIdOnThisCourse;
     private Calendar startDate = new GregorianCalendar();
     private Calendar finishDate = new GregorianCalendar();
     private Set<DaysOfWeek> courseDaysSet = new HashSet<>();
     private List<Task> taskList = new ArrayList<>();

     public Course() {
     }

     @Override
     public String toString() {
         return new StringBuilder().append("\nCourse ID: ").append(courseId).
                 append("\nCourse name: ").append(courseName).
                 append("\nCourse description: ").append(description).
                 append("\nStart date: ").append(startDate.get(Calendar.DATE)).append(".").append(startDate.get(Calendar.MONTH) + 1).append(".").append(startDate.get(Calendar.YEAR)).
                 append("\nEnd date: ").append(finishDate.get(Calendar.DATE)).append(".").append(finishDate.get(Calendar.MONTH) + 1).append(".").append(finishDate.get(Calendar.YEAR)).
                 append("\nDays: ").append(courseDaysSet).toString();
     }

     public String getDescription() {
         return description;
     }

     public Set<Integer> getStudentsIdSet() {
         return studentsIdSet;
     }

     public int getTrainerIdOnThisCourse() {
         return trainerIdOnThisCourse;
     }

     public Calendar getStartDate() {
         return startDate;
     }

     public Calendar getFinishDate() {
         return finishDate;
     }

     public Set<DaysOfWeek> getCourseDaysSet() {
         return courseDaysSet;
     }

     public int getId() {
         return courseId;
     }

     public String getName() {
         return courseName;
     }

     public void setCourseName(String courseName) {
         this.courseName = courseName;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public void addStudentToThisCourse(int studentIdToThisCourse) {
         this.studentsIdSet.add(studentIdToThisCourse);
     }

     public void setTrainerIdOnThisCourse(int trainerIdOnThisCourse) {
         this.trainerIdOnThisCourse = trainerIdOnThisCourse;
     }

     public void setStartDate(Calendar startDate) {
         this.startDate = startDate;
     }

     public void setFinishDate(Calendar finishDate) {
         this.finishDate = finishDate;
     }

     public void setCourseDaysSet(Set<DaysOfWeek> courseDaysSet) {
         this.courseDaysSet = courseDaysSet;
     }

     public void setCourseId(int courseId) {
         this.courseId = courseId;
     }

     public void setTaskList(List<Task> taskList) {
         this.taskList = taskList;
     }
 }
