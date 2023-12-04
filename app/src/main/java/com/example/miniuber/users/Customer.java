package com.example.miniuber.users;

import java.util.List;

public class Customer extends User  implements TripDetails,Registeration {
    private String mobilePhone;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public boolean Login(String userName, String password) {
        //TODO -customer login
        return false;
    }


    public void bookCar()
    {
        //TODO -customer books car
    }
    @Override
    public List<Trip> viewTripsDetails() {
        return null;
    }

    @Override
    public boolean Register(String name, String email, String password, String mobilePhone) {
        return false;
    }
}
