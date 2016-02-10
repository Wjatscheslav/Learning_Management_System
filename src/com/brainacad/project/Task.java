package com.brainacad.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 18.01.2016.
 */
public class Task {
    private static int numberOfTasks = 0;
    private int taskId;
    private String taskName;
    private int note;
    private String taskText;
    private int courseId;
    private static List<Task> taskList = new ArrayList<>();

    public Task(String taskName) {

    }
}
