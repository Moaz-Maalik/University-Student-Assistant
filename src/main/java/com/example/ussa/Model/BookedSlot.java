package com.example.ussa.Model;
import lombok.Data;


public class BookedSlot {
    public Day day;
    public TimeSlot timeSlot;

    public BookedSlot(Day day, TimeSlot timeSlot){this.day = day; this.timeSlot = timeSlot;}
}
