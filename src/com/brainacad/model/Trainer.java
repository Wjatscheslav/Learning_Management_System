package com.brainacad.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 10.01.2016.
 */
public class Trainer implements Serializable{
    private final static long serialVersionUID = 3L;
    private static Integer numberOfTrainers = 0;
    private static Map<Integer,Trainer> trainerMap = new HashMap<>();

    public static Trainer getTrainer(Integer key){
        return trainerMap.get(key);
    }
}
