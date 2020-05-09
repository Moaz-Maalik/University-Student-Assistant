package com.example.ussa.Controller;

import com.opencsv.CSVReader;
import com.example.ussa.Model.*;
import com.example.ussa.repository.CourseRepository;
import com.example.ussa.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/api/timetableReader")
public class TimeTableReader {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;


    @PostMapping("/readCourseList")
    public void readCourseList() throws Exception {
        TimeTable timeTable = TimeTable.getInstance();
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Instructor> instructorList = new ArrayList<>();



        CSVReader reader1 = new CSVReader(new FileReader("C:\\Users\\mujta\\IdeaProjects\\ussa\\src\\main\\resources\\TimeTable1.csv"));
        CSVReader reader2 = new CSVReader(new FileReader("C:\\Users\\mujta\\IdeaProjects\\ussa\\src\\main\\resources\\TimeTable2.csv"));

        //Read CSV line by line and use the string array as you want
        String[] nextLine;
        int i = 2;
        Long id = 0l;
        //read course info
        while ((nextLine = reader1.readNext()) != null) {
            //skip 2 lines
            if (i > 0 ){
                i--;
            }
            else{

                //check if batch title instead of course
                if (!nextLine[0].isEmpty()){
                    //save to courseList
                    Instructor inst1 = new Instructor(nextLine[2]);
                    instructorList.add(inst1);

                    Course c1 =  new Course(id++, nextLine[1], nextLine[0],' ', inst1,null);
                    courseRepository.save(c1);

                    courseList.add(c1);


                }
            }
        }

        int day = 0;
        int slot;
        String search;
        //read time table
        while ((nextLine = reader2.readNext()) != null) {

            if (!nextLine[1].isEmpty() && !nextLine[1].equalsIgnoreCase("Room")){
                //check if day is changed
                if (!nextLine[0].isEmpty()){
                    if (nextLine[0].contains("Monday")){
                        day = 0;
                    }
                    else if (nextLine[0].contains("Tuesday")){
                        day = 1;
                    }
                    else if (nextLine[0].contains("Wednesday")){
                        day = 2;
                    }
                    else if (nextLine[0].contains("Thursday")){
                        day = 3;
                    }
                    else if (nextLine[0].contains("Friday")){
                        day = 4;
                    }
                }
                for (int j = 2; j < 52; j++ ){
                    if (!nextLine[j].isEmpty()){
                        slot = getTimeSlotIndex(j);
                        if (slot != -1){
                            search = nextLine[j];
                            search = search.replaceAll("\\(.*\\)", "");
                            search = search.trim();
                            //find course
                            Course course = searchCourse(courseList, search);

                            timeTable.setTimeTableSlot(Day.values()[day],TimeSlot.values()[slot],new TimeTableSlot(course,new ClassRoom(nextLine[1])));
                        }
                    }
                }
            }
        }
    }
    private int getTimeSlotIndex(int index){
        int ret = 0;

        if (index == 3 || index == 6){
            ret = 0;
        }
        else if (index == 15){
            ret = 1;
        }
        else if (index == 24){
            ret = 2;
        }
        else if (index == 33){
            ret = 3;
        }
        else if (index == 42){
            ret = 4;
        }
        else if (index == 51){
            ret = 5;
        }

        return ret;
    }
    private Course searchCourse(ArrayList<Course> courseList, String courseTitle){
        Course course = null;

        int slots = 0;
        boolean lab = false;
        if (courseTitle.contains("Lab")) lab = true;
        for (Course c : courseList){
            if (lab){
                if (c.getName().contains(courseTitle) && c.getName().contains("Lab")){
                    course = c;
                }
            }
            else{
                if (c.getName().contains(courseTitle) && !c.getName().contains("Lab")){
                    course = c;
                }
            }
        }
        return course;
    }

}