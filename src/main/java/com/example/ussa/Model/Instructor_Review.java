package com.example.ussa.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Instructor_Review extends Review {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Instructor instruct;

    public String getReview(){
        return review;
    }
    public int getRating(){
        return rating;
    }

    public Instructor getCourse(){
        return instruct;
    }

    public void setReview(String r){
        review = r;
    }

    public void setRating(int r){
        rating = r;
    }

    public void setInstruct(Instructor c){
        this.instruct = c;
    }

    public Instructor getInstruct(){return this.instruct;}




    Instructor_Review(){

    }
    Instructor_Review(String R, int r){
        this.review = R;
        this.rating = r;
    }



}
