package com.example.ussa.payload;


import lombok.Setter;
import lombok.Getter;





public class UserSummary {
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String username;

    @Setter
    @Getter
    private String name;



    public UserSummary(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }


}