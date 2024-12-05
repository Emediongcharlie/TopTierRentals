package com.project.TopTierRentals.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class VendorRegisterRequest {

    private Long vendorId;
    private String vendorName;
    private String vendorEmail;
    private String vendorPassword;
    private String vendorPhoneNumber;
    private String vendorAddress;
}
