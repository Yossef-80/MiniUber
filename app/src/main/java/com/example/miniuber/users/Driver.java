package com.example.miniuber.users;

import java.util.List;

public class Driver extends User implements TripDetails{
    private boolean hasACar;
    private Car car;
    private String mobilePhone;

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    private float rate;

    public boolean isHasACar() {
        return hasACar;
    }

    public void setHasACar(boolean hasACar) {
        this.hasACar = hasACar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public boolean Login(String userName, String password) {
        //TODO -create login for driver
        return false;
    }

    @Override
    public boolean Register() {
        return false;
    }


    @Override
    public List<Trip> viewTripsDetails() {
        //TODO -create view trips details
        return null;
    }
    public List<Trip> searchAvailableTrips()
    {
     //TODO -create view trip details
        return null;
    }

}
