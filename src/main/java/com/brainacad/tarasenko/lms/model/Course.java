 package com.brainacad.tarasenko.lms.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.*;

 /**
 * Created by user on 04.02.2016.
 */
public class Course implements Serializable{
     private final static long serialVersionUID = 1L;
     public enum DaysOfWeek{
         MON,
         TUE,
         WED,
         THU,
         FRI,
         SAT,
         SUN;
     }
     private String name;
     private long id;
     private String description;
     private Date startDate = null;
     private Date finishDate = null;
     private Set<DaysOfWeek> courseDaysSet = new TreeSet<>();
     private Set<Integer> studentsSet = new TreeSet<>();
     private List<Task> taskList = new ArrayList<>();

     public Course() {
     }

     @Override
     public String toString() {
         DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
         return String.format("\nCourse ID: %d\nCourse name: %s\nCourse description: %s\nStart date: %s\nEnd date: %s\nDays: %s", id, name, description, dateFormat.format(startDate), dateFormat.format(finishDate), courseDaysSet);
     }

     public String getDescription() {
         return description;
     }

     public Date getStartDate() {
         return startDate;
     }

     public Date getFinishDate() {
         return finishDate;
     }

     public Set<DaysOfWeek> getCourseDaysSet() {
         return courseDaysSet;
     }

     public long getId() {
         return id;
     }

     public String getName() {
         return name;
     }

     public void setCourseName(String courseName) {
         this.name = courseName;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public void setStartDate(Date startDate) {
         this.startDate = startDate;
     }

     public void setFinishDate(Date finishDate) {
         this.finishDate = finishDate;
     }

     public void setCourseDaysSet(Set<DaysOfWeek> courseDaysSet) {
         this.courseDaysSet = courseDaysSet;
     }

     public void setCourseId(int courseId) {
         this.id = courseId;
     }

     public void setTaskList(List<Task> taskList) {
         this.taskList = taskList;
     }
     public void setName(String name) {
         this.name = name;
     }

     public void setId(long id) {
         this.id = id;
     }

     public Set<Integer> getStudentsSet() {
         return studentsSet;
     }

     public void setStudentsSet(Set<Integer> studentsSet) {
         this.studentsSet = studentsSet;
     }

     public List<Task> getTaskList() {
         return taskList;
     }
 }
