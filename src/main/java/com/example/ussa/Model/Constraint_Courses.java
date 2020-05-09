package com.example.ussa.Model;

import com.example.ussa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ussa.exception.CourseNotFound;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Constraint_Courses {

    @Autowired
    static CourseRepository courseRepository;

    public static List<Course> getConstraintsCourses(List<Subject> subjects) throws CourseNotFound {
        List<Course> courses = new ArrayList<Course>();
        TimeTable tt = TimeTable.getInstance();
        Day days[] = Day.values();
        TimeSlot slots[] = TimeSlot.values();
        int dayIndex = 0;
        int timeIndex = 2;
        ArrayList<BookedSlot> booked = new ArrayList<>();

        for (Subject sub : subjects) {
            dayIndex = 0;
            timeIndex = 2;
            boolean found = false;
            while (!found && (dayIndex * timeIndex) < 20) { // 5 days 6 time slots

                if (!booked.contains(new BookedSlot(days[dayIndex], slots[timeIndex]))) {
                    TimeTableRow ttr = tt.getRow(days[dayIndex], slots[timeIndex]);
                    if (ttr.subExists(sub)) {
                        courses.add(ttr.retCourse(sub));
                        booked.add(new BookedSlot(days[dayIndex], slots[timeIndex]));
                        found = true;
                    }
                }
                if (timeIndex >= 5) { // timeIndex should vary from 0 to 5
                    timeIndex = 0;
                    dayIndex++;
                } else
                    timeIndex++;

            }


        }

        return courses;

    }
}