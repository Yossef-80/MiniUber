package com.example.miniuber.users;

import java.util.List;

public class Customer extends User  implements TripDetails {
    private String mobilePhone;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public boolean Login(String userName, String password) {
        return false;
    }


    @Override
    public List<Trip> viewTripDetails() {
        return null;
    }
}
