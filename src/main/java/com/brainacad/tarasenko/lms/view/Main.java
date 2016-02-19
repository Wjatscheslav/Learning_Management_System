package com.brainacad.tarasenko.lms.view;

import com.brainacad.tarasenko.lms.manager.CourseManager;
import com.brainacad.tarasenko.lms.manager.StudentManager;
import com.brainacad.tarasenko.lms.manager.TrainerManager;
import com.brainacad.tarasenko.lms.util.Checker;
import java.util.Scanner;

/**
 * Created by user on 10.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        CourseManager courseManager = CourseManager.getInstance();
        StudentManager studentManager = StudentManager.getInstance();
        TrainerManager trainerManager = TrainerManager.getInstance();
        Checker checker = Checker.getInstance();
        Scanner commandScanner = new Scanner(System.in);

start:      for (;;) {
            System.out.println("Please, enter the command:");
            String[] commandParts = checker.checkCommand(commandScanner.nextLine());
            if (commandParts == null){
                continue;
            }
            switch (commandParts[0]) {
                case "create":
                    switch (commandParts[1]) {
                        case "course":
                            courseManager.createCourse();
                            break;
                        case "student":
                            studentManager.createStudent();
                            break;
                        case "trainer":
                            trainerManager.createTrainer();
                            break;
                    }
                    break;
                case "show":
                    switch (commandParts[1]) {
                        case "course":
                            System.out.println(courseManager.getCourse(Integer.parseInt(commandParts[2])));
                            break;
                        case "student":
                            System.out.println(studentManager.getStudent(Integer.parseInt(commandParts[2])));
                            break;
                        case "trainer":
                            System.out.println(trainerManager.getTrainer(Integer.parseInt(commandParts[2])));
                            break;
                        case "courses":
                            courseManager.printAllCourses();
                            break;
                        case "students":
                            courseManager.printStudents(Integer.parseInt(commandParts[2]));
                    }
                    break;
                case "transfer":
                    switch (commandParts[3]){
                        case "add":
                            //studentManager.addStudent(commandParts[2],commandParts[4]);
                            break;
                        case "remove":
                            //studentManager.removeStudent(commandParts[2],commandParts[4]);
                            break;
                    }
                    break;
                case "help":
                    help();
                    break;
                case "exit":
                    exit();
                    break start;
            }
        }
    }
    public static void exit(){
        StudentManager.getInstance().saveToFile();
        CourseManager.getInstance().saveToFile();
        TrainerManager.getInstance().saveToFile();
    }
    public static void help(){
        System.out.println("create course\t\t\t\t\t - launches course creation");
        System.out.println("create student\t\t\t\t\t - launches student creation");
        System.out.println("create trainer\t\t\t\t\t - launches trainer creation");
        System.out.println("show student <int>\t\t\t\t - displays the information about the student by ID");
        System.out.println("show course <int>\t\t\t\t - displays the information about the course by ID");
        System.out.println("show trainer <int>\t\t\t\t - displays the information about the trainer by ID");
        System.out.println("show courses\t\t\t\t\t - displays the names of all courses");
        System.out.println("show students <int> \t\t\t - displays the names of all students by courseID");
        System.out.println("exit \t\t\t\t\t\t\t - exit the program and save the changes to the files");
    }
    static {
        CourseManager.getInstance().readFromFile();
        StudentManager.getInstance().readFromFile();
        TrainerManager.getInstance().readFromFile();
    }
}


