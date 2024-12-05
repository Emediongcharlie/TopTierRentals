package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.VendorLoginRequest;
import com.project.TopTierRentals.dtos.request.VendorRegisterRequest;
import com.project.TopTierRentals.dtos.response.VendorLoginResponse;
import com.project.TopTierRentals.dtos.response.VendorRegisterResponse;

public interface VendorService {
    VendorRegisterResponse RegisterVendor(VendorRegisterRequest request);

    VendorLoginResponse LoginVendor(VendorLoginRequest request);


}
