package com.example.ussa.payload;

import lombok.Getter;
import lombok.Setter;

public class UserIdentityAvailability {

    @Getter
    @Setter
    private Boolean available;

    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }


}
