package com.project.TopTierRentals.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AdminRegisterRequest {

    private String name;
    private String password;
    private String email;
    private Long id;
}
