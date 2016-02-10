package com.brainacad.project;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 10.01.2016.
 */
public class Trainer extends Person{
    private static Integer numberOfTrainers = 0;
    private static Map<Integer,Trainer> trainerMap = new HashMap<>();

    private Trainer(String trainerFirstName, String trainerLastName) {
        super(trainerFirstName,trainerLastName);
        this.setId(numberOfTrainers);
        numberOfTrainers++;
    }

    public static void addTrainer(String name, String surname){
        trainerMap.put(numberOfTrainers,new Trainer(name,surname));
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.getFirstName()).append(" ").append(this.getLastName()).toString();
    }

    public static Trainer getTrainer(Integer key){
        return trainerMap.get(key);
    }
}
