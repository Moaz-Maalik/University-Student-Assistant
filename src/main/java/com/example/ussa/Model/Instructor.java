package com.example.ussa.Model;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.List;



@Entity
@Table(name = "Instructors")

public class Instructor {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 60)
    @Getter
    @Setter
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Course_Instructors",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> Courses = new ArrayList<>();


    @OneToMany(targetEntity = Course_Review.class)
    @Column
    @Getter
    @Setter
    private List Instructor_Review = new ArrayList();




    public float getAvgRating(){
        float sum = 0;
        float avg = 0;

        for ( Object r: Instructor_Review
        ) {
            Review theR = (Review) r;
            sum+= theR.rating;

        }
        avg = sum /  Instructor_Review.size();
        return avg;
    }

    Instructor(){

    }

    public Instructor(String name){this.name = name;}
    public void addReview(Review r){
        this.getInstructor_Review().add(r);
    }

    public void removeReview(Review r){this.getInstructor_Review().remove(r);}

    public  void addCourse(Course c){this.Courses.add(c);}

    public  void removeCourse(Course c){this.Courses.remove(c);}

}
