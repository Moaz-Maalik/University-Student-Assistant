package com.example.ussa.Model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class EmptySpotFinder {
    private static EmptySpotFinder instance;    //Singleton Class

    int[][] adjMatrix = {
            {0,14,13,12,13,14,15,16,5,4,5,6,7,8,9,22,23},
            {14,0,1,2,3,4,5,6,11,10,9,10,11,12,13,12,13},
            {13,1,0,1,2,3,4,5,10,9,8,9,10,11,12,11,12},
            {12,2,1,0,1,2,3,4,9,8,7,8,9,10,11,10,11},
            {13,3,2,1,0,1,2,3,10,9,8,9,10,11,12,9,10},
            {14,4,3,2,1,0,1,2,11,10,9,10,11,12,13,8,9},
            {15,5,4,3,2,1,0,1,12,11,10,11,12,13,14,7,8},
            {16,6,5,4,3,2,1,0,13,12,11,12,13,14,15,8,9},
            {5,11,10,9,10,11,12,13,0,1,2,3,4,5,6,19,20},
            {4,10,9,8,9,10,11,12,1,0,1,2,3,4,5,18,19},
            {5,9,8,7,8,9,10,11,2,1,0,1,2,3,4,17,18},
            {6,10,9,8,9,10,11,12,3,2,1,0,1,2,3,16,17},
            {7,11,10,9,10,11,12,13,4,3,2,1,0,1,2,15,16},
            {8,12,11,10,11,12,13,14,5,4,3,2,1,0,1,14,15},
            {9,13,12,11,12,13,14,15,6,5,4,3,2,1,0,15,16},
            {22,12,11,10,9,8,7,8,19,18,17,16,15,14,15,0,1},
            {23,13,12,11,10,9,8,9,20,19,18,17,16,15,16,1,0},
    };


    private EmptySpotFinder() {
        //do nothing
    }

    private static EmptySpotFinder getInstance() {
        if (instance == null)
            instance = new EmptySpotFinder();
        return instance;
    }

    String CalculateTimeSlot() {
        String ret = null;

        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int min = rightNow.get(Calendar.MINUTE);

        if (hour == 8 || (hour == 9 && min < 30)) {
            ret = "FIRST";
        }
        else if (hour == 10 || hour == 9) {
            ret = "SECOND";
        }
        else if (hour == 11 || (hour == 12 && min < 30)) {
            ret = "THIRD";
        }
        else if (hour == 13 || hour == 12) {
            ret = "FOURTH";
        }
        else if (hour == 14 || (hour == 15 && min < 30)) {
            ret = "FIFTH";
        }
        else if (hour == 16 || hour == 15) {
            ret = "SIXTH";
        }

        return ret;
    }

    int CalculateClassIndex(String className) {
        int ret = -1;
        if (className.equals("Seminar Hall")) {
            ret = 0;
        }
        else if (className.equals("CS-1")) {
            ret = 1;
        }
        else if (className.equals("CS-2")) {
            ret = 2;
        }
        else if (className.equals("CS-3")) {
            ret = 3;
        }
        else if (className.equals("CS-4")) {
            ret = 4;
        }
        else if (className.equals("CS-5")) {
            ret = 5;
        }
        else if (className.equals("CS-6")) {
            ret = 6;
        }
        else if (className.equals("CS-7")) {
            ret = 7;
        }
        else if (className.equals("CS-8")) {
            ret = 8;
        }
        else if (className.equals("CS-9")) {
            ret = 9;
        }
        else if (className.equals("CS-10")) {
            ret = 10;
        }
        else if (className.equals("CS-11")) {
            ret = 11;
        }
        else if (className.equals("CS-12")) {
            ret = 12;
        }
        else if (className.equals("CS-13")) {
            ret = 13;
        }
        else if (className.equals("CS-14")) {
            ret = 14;
        }
        else if (className.equals("CS-15")) {
            ret = 15;
        }
        else if (className.equals("CS-16")) {
            ret = 16;
        }
        return ret;
    }

    List<String> EmptyClasses() {
        List<String> allClasses = Arrays.asList("Seminar Hall","CS-1","CS-2","CS-3","CS-4","CS-5","CS-6","CS-7","CS-8","CS-9","CS-10","CS-11","CS-12","CS-13","CS-14","CS-15","CS-16");

        List<String> retClasses = null;

        String day = LocalDate.now().getDayOfWeek().name();
        String timeSlot = CalculateTimeSlot();

        if ((day != null && timeSlot != null) || day.equals("SATURDAY") || day.equals("SUNDAY")) {
            TimeTable timeTable = TimeTable.getInstance();

            TimeTableRow requiredTTR = timeTable.getRow(Day.valueOf(day), TimeSlot.valueOf(timeSlot));

            for (TimeTableSlot tts : requiredTTR.row) {
                String classRoomName = tts.classRoom.getName();
                if (allClasses.contains(classRoomName)) {
                    allClasses.remove(classRoomName);
                }
            }

            if (allClasses.size() != 17) {
                for (String cls : allClasses) {
                    retClasses.add(cls);
                }
            }
        }
        return retClasses;
    }
    String BestRatedClass() {
        List<String> emptyClasses = this.EmptyClasses();

        String ret = null;

        if (emptyClasses != null) {
            TimeTable timeTable = TimeTable.getInstance();
            float maximumVal = -1;
            String bestClassName = null;
            for (String emptyClass: emptyClasses) {
                int classIndex = CalculateClassIndex(emptyClass);
                float classVal = (timeTable.classRooms.get(classIndex)).getVal();
                if (classVal > maximumVal) {
                    maximumVal = classVal;
                    bestClassName = emptyClass;
                }
            }
            ret = bestClassName;
        }

        return ret;
    }
    String NearestClass(String currentLocation) {
        List<String> emptyClasses = this.EmptyClasses();
        List<String> allClasses = Arrays.asList("Seminar Hall","CS-1","CS-2","CS-3","CS-4","CS-5","CS-6","CS-7","CS-8","CS-9","CS-10","CS-11","CS-12","CS-13","CS-14","CS-15","CS-16");

        String ret = null;

        int minDistance = 99999, minDistIndex= -1;

        int classIndex;
        int currentIndex = allClasses.indexOf(currentLocation);
        if (currentIndex != -1) {
            if (emptyClasses != null) {
                for (String cls : emptyClasses) {
                    classIndex = allClasses.indexOf(cls);
                    if (adjMatrix[classIndex][currentIndex] < minDistance) {
                        minDistance = adjMatrix[classIndex][currentIndex];
                        minDistIndex = classIndex;
                    }
                }
                ret = allClasses.get(minDistIndex);
            }
        }
        return ret;
    }
}
