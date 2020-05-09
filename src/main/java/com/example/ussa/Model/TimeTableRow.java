package com.example.ussa.Model;

import java.util.ArrayList;
import lombok.Data;

@Data
public class TimeTableRow {


    ArrayList<TimeTableSlot> row = new ArrayList<TimeTableSlot>();

    public void addTimeTableSlot(TimeTableSlot tts){
        row.add(tts);
    }

    public boolean subExists(Subject sub){
        boolean found = false;
        for (TimeTableSlot ts:row ) {
            if (ts.getCourse().equals(sub))
                found = true;


        }
        return found;
    }


    public Course retCourse(Subject sub){
        Course c = null;
        for (TimeTableSlot ts:row ) {
            if (ts.getCourse().equals(sub))
                c =  ts.getCourse();

        }
        return  c;
    }


}
