package com.example.ussa.Model;

import com.example.ussa.Model.Course;
import lombok.Data;

@Data
public class TimeTableSlot {

    public Course course;
    public ClassRoom classRoom;

    public TimeTableSlot(Course course, ClassRoom classRoom){this.classRoom = classRoom; this.course = course;}


}
