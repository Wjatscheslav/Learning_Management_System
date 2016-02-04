package com.brainacad.project;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by user on 04.02.2016.
 */
public class Course {
    private static int numberOfCourses;
    private String courseName;
    private String description;
    private int[] studentsIDsArray;
    private int trainerIdOnThisCourse;
    Calendar startDate = new GregorianCalendar();
    Calendar finishDate = new GregorianCalendar();

}
