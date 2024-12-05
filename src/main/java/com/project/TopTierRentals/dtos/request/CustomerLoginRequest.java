package com.project.TopTierRentals.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CustomerLoginRequest {

    private String Email;
    private String Password;
}
