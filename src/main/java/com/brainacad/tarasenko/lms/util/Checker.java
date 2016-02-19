package com.brainacad.tarasenko.lms.util;

import com.brainacad.tarasenko.lms.model.Course;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by user on 16.02.2016.
 */
public class Checker {
    private static Checker instance = new Checker();
    private final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    private final Pattern datePattern = Pattern.compile("^(((0?[1-9])|([1,2][0-9])|(3[0,1]))[\\.,-]((0?[1,3,5,7,8])|(1[0,2]))[\\.,-](2[0-9][0-9][0-9]))|" + //for month's with 31 day
            "(((0?[1-9])|([1,2][0-9])|(30))[\\.,-]((0?[4,6,9])|(11))[\\.,-](2[0-9][0-9][0-9]))|" + //for month's with 30 days
            "(((0?[1-9])|(1[0-9])|(2[0-8]))[\\.,-](0?2)[\\.,-](2[0-9][0-9][0-9]))|" + //for February (not leap year)
            "((0?[1-9])|(1[0-9])|(2[0-9]))[\\.,-](0?2)[\\.,-]((2[0-9][0,2,4,6,8][0,4,8])|(2[0-9][1,3,5,7,9][2,6]))$"); //for February (leap year)
    Pattern commandPattern = Pattern.compile("^\\s*create\\s*(course||student||trainer)\\s*||\\s*show\\s*(course||student||trainer||students)\\s*\\d+||\\s*show\\s*courses\\s*||" +
            "\\s*transfer\\s*student\\s*\\d+\\s*(add||remove)\\s*\\d+\\s*||\\s*exit\\s*||\\s*help\\s*$");
    private Pattern namePattern = Pattern.compile("^[A-Z][a-z]+$");

    public static Checker getInstance(){
        return instance;
    }

    public Set<Course.DaysOfWeek> checkDayOfWeek (String days){
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

    public Date checkDate(String dateString) {
        Date date = null;
        if (datePattern.matcher(dateString).matches()) {
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } return date;
    }

    public String checkName(String name) {
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

    public String[] checkCommand(String command) {
        if (commandPattern.matcher(command).matches()) {
            String[] commandParts = new String[5];
            Scanner sc = new Scanner(command);
            int i = 0;
            while (sc.hasNext()) {
                commandParts[i] = sc.next();
                i++;
            }
            return commandParts;
        } else {
            try {
                throw new InputMismatchException();
            } catch (InputMismatchException e){
                System.out.println("Invalid command! Try again.");
                return null;
            }
        }
    }
}
