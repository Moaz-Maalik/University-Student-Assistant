package com.example.ussa.Controller;

import com.example.ussa.Model.*;
import com.example.ussa.exception.CourseNotFound;
import com.example.ussa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimeTableController {

    @Autowired
    UserRepository userRepository;

    @PutMapping("/optimal")
    public void addCourses(@RequestBody optimalInput oinp) throws CourseNotFound {
        List<Course> Courses = OptimalCourses.getOptimalCourses((ArrayList<Subject>) oinp.sub);
        //System.out.println(sub);
        System.out.println(oinp);
       //// System.out.println(UID);System.out.println(UID);System.out.println(UID);System.out.println(UID);System.out.println(UID);System.out.println(UID);
        Long id =  Long.valueOf(oinp.ID);
        User user = userRepository.getOne(id);
        user.setCourses(Courses);
        userRepository.save(user);


    }

}
