package com.brainacad.project;

import java.util.*;

/**
 * Created by user on 10.01.2016.
 */
public class Main {
    static enum DaysOfWeek{
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);
        private int dayId;
        private DaysOfWeek(int dayId){
            this.dayId = dayId;
        }
        public int getDayId() {
            return dayId;
        }
    }
    public static void main(String[] args){
        Student.addStudent("Viacheslav","Tarasenko");
        Student.addStudent("Vladimir","Fastovez");
        Student.addStudent("Konstantin","Kalinovskiy");
        Student.addStudent("Andrey","Denisov");
        Student.addStudent("Viacheslav","Evlahov");
        Student.addStudent("Oleksii","Karpenko");
        Trainer.addTrainer("Alexander","Semeniuk");
        Set<Integer> daysSet = new HashSet<>();
        daysSet.add(1);
        daysSet.add(3);
        daysSet.add(5);

        System.out.println(Trainer.getTrainer(0));
        int i = 0;
        while(Student.getStudent(i)!=null) {
            System.out.println(Student.getStudent(i));
            i++;
        }
        Calendar start = new GregorianCalendar();
        start.set(2015,10,01);
        System.out.println(start.get(Calendar.DAY_OF_MONTH) + " " + start.get(Calendar.MONTH) + " " + start.get(Calendar.YEAR));

        for (DaysOfWeek days : DaysOfWeek.values()){
            if (daysSet.contains(days.getDayId())){
                System.out.println(days.name());
            }
        }
    }
}
