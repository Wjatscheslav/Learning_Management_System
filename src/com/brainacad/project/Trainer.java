package com.brainacad.project;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 10.01.2016.
 */
public class Trainer {
    private String trainerName;
    private String trainerSurname;
    private Integer trainerId;
    private static Integer numberOfTrainers = 0;
    private static Map<Integer,Trainer> trainerMap = new HashMap<>();

    public Trainer(String trainerName, String trainerSurname) {
        this.trainerName = trainerName;
        this.trainerSurname = trainerSurname;
        this.trainerId = numberOfTrainers;
    }

    public static void addTrainer(String name, String surname){
        trainerMap.put(numberOfTrainers,new Trainer(name,surname));
        numberOfTrainers++;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(trainerName).append(" ").append(trainerSurname).toString();
    }

    public static void printTrainers (){
        System.out.println(trainerMap);
    }

    public static String getTrainer(Integer key){
        return new StringBuilder().append(trainerMap.get(key)).toString();
    }
}
