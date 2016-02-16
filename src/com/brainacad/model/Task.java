package com.brainacad.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.01.2016.
 */
public class Task {
    private final static long serialVersionUID = 4L;
    private static int numberOfTasks = 0;
    private int taskId;
    private String taskName;
    private int note;
    private String taskText;
    private int courseId;
//    private static List<Task> taskList = new ArrayList<>();

    public Task() {
    }
}
