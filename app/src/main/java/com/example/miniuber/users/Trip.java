package com.example.miniuber.users;

public class Trip {
    private Customer customer;
    private Driver driver;
    private String pickPoint;
    private String destination;
    private int carFare;
    private String tripTime;
    public int calcFare(String pickPoint,String destination)
    {
        //we can add facade here by each city with fare(cairo =>3EGP/km,alex =>2EGP/km,etc)
        //,then get the distance between pick and distnation
        //then add fare price depend on model of the car
        //then add discount price to the trip
        //then calculate the cumulative Fare
        return 0;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getPickPoint() {
        return pickPoint;
    }

    public void setPickPoint(String pickPoint) {
        this.pickPoint = pickPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCarFare() {
        return carFare;
    }

    public void setCarFare(int carFare) {
        this.carFare = carFare;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }





}
