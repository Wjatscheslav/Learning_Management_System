package com.brainacad.project;

import java.util.Scanner;

/**
 * Created by user on 04.02.2016.
 */
public class Person {

    private int id;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    protected Person(String name, String surname) {
        this.firstName = checkName(name);
        this.lastName = checkName(surname);
    }

    private static String checkName(String name) {
        Scanner sc = new Scanner(System.in);
        String checkedName = name.toLowerCase();
        char firstLetter = (char) (checkedName.charAt(0) - 32);
        checkedName = checkedName.replaceFirst("[a-z]", String.valueOf(firstLetter));
        if (checkedName.matches("^[A-Z]*[a-z]+$")) {
            return checkedName;
        } else {
            System.out.println("Incorrect input! Name must contain only letters. Try again.");
            boolean isCorrect = false;
            while (!isCorrect) {
                checkedName = sc.nextLine().toLowerCase();
                firstLetter = (char) (checkedName.charAt(0) - 32);
                checkedName = checkedName.replaceFirst("[a-z]", String.valueOf(firstLetter));
                if (checkedName.matches("^[A-Z]*[a-z]+$")) {
                    isCorrect = true;
                }
            }
            return checkedName;
        }
    }
}
