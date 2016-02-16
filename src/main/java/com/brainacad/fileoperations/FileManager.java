package com.brainacad.fileoperations;

import com.brainacad.manager.CourseManager;
import com.brainacad.manager.StudentManager;
import com.brainacad.model.Course;
import com.brainacad.model.Student;
import com.brainacad.model.Trainer;
import java.io.*;
import java.util.HashMap;

/**
 * Created by user on 11.02.2016.
 */
public class FileManager{
    private static String studentPath = "data.ser";
    private static int size;

    public static void writeToFile(){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(studentPath))) {
            size = (StudentManager.getStudentMap().size() + CourseManager.getCourseMap().size());
            outputStream.writeInt(size);
            for (Object o : StudentManager.getStudentMap().values()) {
                outputStream.writeObject(o);
            }
            for (Object o : CourseManager.getCourseMap().values()) {
                outputStream.writeObject(o);
            }
//            for (Object o : TrainerManager.getTrainerMap().values()) {
//                outputStream.writeObject(o);
//            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void readFromFile(){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(studentPath))) {
            size = inputStream.readInt();
            while (size > 0) {
                Object o = inputStream.readObject();
                if (o instanceof Student) {
                    StudentManager.addStudent((Student) o);
                } else if (o instanceof Course) {
                    CourseManager.addCourse((Course) o);
                } else if (o instanceof Trainer) {
//                    TrainerManager.setTrainer((Trainer)o);
                }
                size--;
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
