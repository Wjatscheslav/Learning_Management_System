package com.brainacad.tarasenko.lms.manager;

import com.brainacad.tarasenko.lms.model.Trainer;
import com.brainacad.tarasenko.lms.util.Checker;

import java.io.*;
import java.util.*;

/**
 * Created by user on 18.02.2016.
 */
public class TrainerManager {

    private static final String FILE_PATH = "trainer.ser";

    private static TrainerManager instance = new TrainerManager();
    private Map<Integer,Trainer> trainerMap = new TreeMap<>();

    private TrainerManager() {
    }

    public static TrainerManager getInstance (){
        return instance;
    }

    public void createTrainer(){
        Set<Integer> courseIdSet = new TreeSet<>();
        String courses;
        Scanner sc = new Scanner(System.in);
        Scanner courseScanner;
        Checker checker = Checker.getInstance();
        int courseId;
        Trainer trainer = new Trainer();
        trainer.setId(trainerMap.size() + 1);
        do {
            System.out.println("First name: ");
            trainer.setFirstName(checker.checkName(sc.next()));
            System.out.println("Last name: ");
            trainer.setLastName(checker.checkName(sc.next()));
        } while(!isTrainerUnique(trainer));
        System.out.println("Age: ");
        trainer.setAge(sc.nextInt());
        System.out.println("Course(s): ");
        courses = sc.next();
        courseScanner = new Scanner(courses).useDelimiter(",");
        while (courseScanner.hasNextInt()) {
            courseId = courseScanner.nextInt();
            if (CourseManager.getInstance().isCourseExists(courseId)) {
                courseIdSet.add(courseId);
            } else {
                System.out.println("Course with id " + courseId + " doesn't exist.");
            }
        }
        trainer.setCourseIdSet(courseIdSet);
        System.out.println("New trainer has been successfully created!");
        System.out.println(trainer);
        trainerMap.put(trainerMap.size() + 1,trainer);
    }

    private boolean isTrainerUnique(Trainer trainer){
        boolean b = true;
        for (Trainer trainer1 : trainerMap.values()){
            if (trainer.equals(trainer1)){
                b = !b;
                System.out.println("Student name should be unique");
            }
        }
        return b;
    }

    public Trainer getTrainer(int id){
        if (trainerMap.containsKey(id)){
            return trainerMap.get(id);
        } else {
            throw new NoSuchElementException("Student with id " + id + " doesn't exist.");
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeInt(trainerMap.size());
            for (Trainer trainer : trainerMap.values()){
                outputStream.writeObject(trainer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        int size = 0;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            size = inputStream.readInt();
            while (size > 0){
                trainerMap.put(trainerMap.size() + 1, (Trainer) inputStream.readObject());
                size--;
            }
        } catch (ClassNotFoundException e){
            System.out.println("File is corrupted!");
        } catch (EOFException e){
            System.out.println("File " + FILE_PATH + " is empty!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
