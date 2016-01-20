package com.brainacad.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.01.2016.
 */
public class Task {
    private String taskName;
    public static List<Task> taskList = new ArrayList<>();

    public static void addTask(String taskName){
        Task.taskList.add(new Task(taskName));
    }

    @Override
    public String toString() {
        return new StringBuilder().append(taskName).toString();
    }

    public static void printTasks(){
        System.out.println(taskList);
    }

    public Task(String taskName) {
        this.taskName = taskName;
    }
}
