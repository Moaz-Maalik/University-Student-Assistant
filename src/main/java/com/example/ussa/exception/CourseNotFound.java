package com.example.ussa.exception;

public class CourseNotFound extends Exception {

    public String message;

    public CourseNotFound(String msg){
        message = msg;
    }



}
