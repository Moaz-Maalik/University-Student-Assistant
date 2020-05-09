package com.example.ussa.Model;


import lombok.Data;

@Data
public class Subject {

    String code;
    String name;

    Subject (String code, String name ){
        this.code = code;
        this.name = name;
    }


}
