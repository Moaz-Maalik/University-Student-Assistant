package com.example.ussa.Model;

import java.util.Random;
import lombok.*;



@Data
public class ClassRoom {

    private String name;
    private float val ;

    public ClassRoom(String name){
        this.name = name;
        Random rand = new Random();
        val = rand.nextFloat();

    }


}
