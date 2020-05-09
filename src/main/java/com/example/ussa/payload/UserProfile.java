package com.example.ussa.payload;
import com.example.ussa.Model.Course;
import lombok.Setter;
import lombok.Getter;


import java.util.List;
import java.util.Set;


public class UserProfile {
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String username;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private List<Course> courseList;


    public UserProfile(Long id, String username, String name, List<Course> courses) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.courseList = courses;
    }


}