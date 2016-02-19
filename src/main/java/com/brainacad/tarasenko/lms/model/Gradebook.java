package com.brainacad.tarasenko.lms.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.02.2016.
 */
public class Gradebook {
    private int id;
    private List<Integer> notesList = new ArrayList<>();

    public Gradebook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getNotesList() {
        return notesList;
    }

    public void setNotesList(List<Integer> notesList) {
        this.notesList = notesList;
    }
}
