package com.example.miniuber.users.trip;

import android.content.Context;
import android.location.Address;

import java.sql.Driver;

public class Trip  implements TripCreation{
    private String id;


    boolean hasADriver;
    private String customer;
    private String driver;
    private String pickPoint;
    private String destination;
    private int carFare;
    private String tripTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private int rate;
    public double calcFare(Address pickpoint,Address destination)
    {
        //TODO -calc fare
        CalcTripDistance distance= new CalcTripDistance();
        distance.TripDistance(pickpoint,destination);

        //we can add facade here by each city with fare(cairo =>3EGP/km,alex =>2EGP/km,etc)
        //,then get the distance between pick and distnation
        //then add fare price depend on model of the car
        //then add discount price to the trip
        //then calculate the cumulative Fare
        return distance.calcPrice();
    }
    @Override
    public void CreateTrip(Address pickPoint, Address destination, Context context)
    {
        Trip trip=new Trip();
        trip.setCustomer("1");
        trip.setTripTime(tripTime);
        trip.setPickPoint(pickPoint.getAddressLine(0));
        trip.setDestination(destination.getAddressLine(0));
        trip.calcFare(pickPoint,destination);
        trip.setHasADriver(false);



    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


    public boolean isHasADriver() {
        return hasADriver;
    }

    public void setHasADriver(boolean hasADriver) {
        this.hasADriver = hasADriver;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
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
