package com.example.ussa.Model;


import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Swapper")
public class Swapper {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    User Swapper;

    @ManyToOne
    Course currentCourse;

    @ManyToOne
    Course requiredCourse;

    public Course getRequiredCourse() {
        return requiredCourse;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setRequiredCourse(Course requiredCourse) {
        this.requiredCourse = requiredCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public User getSwapper() {
        return Swapper;
    }

    public void setSwapper(User swapper) {
        Swapper = swapper;
    }

    Swapper(){}
    Swapper(User _user,Course cur,Course req){

        this.requiredCourse=req;
        this.currentCourse=cur;
        this.Swapper=_user;
    }

    User swap(User _swapper){
        List<Course> courses= this.Swapper.getCourses();
        courses.remove(currentCourse);
        courses.add(requiredCourse);
        this.Swapper.setCourses(courses);
        courses= _swapper.getCourses();
        courses.remove(requiredCourse);
        courses.add(currentCourse);
        _swapper.setCourses(courses);
        return _swapper;
    }
}
