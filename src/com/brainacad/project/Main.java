package com.brainacad.project;

/**
 * Created by user on 10.01.2016.
 */
public class Main {
    public static void main(String[] args){
        Student.addStudent("Viacheslav","Tarasenko");
        Student.addStudent("Vladimir","Fastovez");
        Student.addStudent("Konstantin","Kalinovskiy");
        Student.addStudent("Andrey","Denisov");
        Student.addStudent("Viacheslav","Evlahov");
        Student.addStudent("Oleksii","Karpenko");
        Student.printStudents();
        Task.addTask("Task1");
        Task.addTask("Task2");
        Task.addTask("Task3");
        Task.printTasks();
        Trainer.addTrainer("Alexander","Semeniuk");
        Trainer.printTrainers();
        System.out.println(Trainer.getTrainer(0));
        System.out.println(Student.getStudent(0));
        Student.getStudent(0).doTask("Task1",90);
        Student.getStudent(0).printNotes();

    }
}
