package com.project.TopTierRentals.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CustomerRegisterRequest {

    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String customerPassword;
}
