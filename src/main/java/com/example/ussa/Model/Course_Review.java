package com.example.ussa.Model;


import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity

public class Course_Review extends Review{

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Course course;

    public String getReview(){
        return review;
    }
    public int getRating(){
        return rating;
    }

    public Course getCourse(){
        return course;
    }

    public void setReview(String r){
        review = r;
    }

    public void setRating(int r){
        rating = r;
    }

    public void setCourse(Course c){
        this.course = c;
    }

    Course_Review(){

    }
    Course_Review(String R, int r){
        this.review = R;
        this.rating = r;
    }



}
