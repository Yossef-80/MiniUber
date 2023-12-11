package com.example.miniuber.users.trip;

import static android.content.Context.MODE_PRIVATE;

import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.miniuber.database.UberDBHelper;

import java.sql.Driver;

public class Trip  implements TripCreation{
    private int id;


    boolean hasADriver;
    private int customer;
    private int driver;
    private String pickPoint;
    private String destination;
    private int carFare;
    private String tripTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private int rate;
    public int calcFare(Address pickpoint,Address destination)
    {
        //TODO -calc fare
        CalcTripDistance distance= new CalcTripDistance();
        distance.TripDistance(pickpoint,destination);

        //we can add facade here by each city with fare(cairo =>3EGP/km,alex =>2EGP/km,etc)
        //,then get the distance between pick and distnation
        //then add fare price depend on model of the car
        //then add discount price to the trip
        //then calculate the cumulative Fare

        setCarFare(distance.calcPrice());
        return getCarFare();
    }
    @Override
    public void CreateTrip(Address pickPoint,Address destination,String tripDate, Context context)
    {



        setHasADriver(false);
        setPickPoint(pickPoint.getAddressLine(0));
        setDestination(destination.getAddressLine(0));
        setTripTime(tripDate);


        SharedPreferences sharedPreferences=context.getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        int customerID = sharedPreferences.getInt("id",0);
        setCustomer(customerID);



        calcFare(pickPoint,destination);

        UberDBHelper dbHelper = new UberDBHelper(context);
        if(! dbHelper.CreateTrip(getPickPoint(),getDestination(),getTripTime(),getCustomer(),getTripTime(),getCarFare())) {

            Toast.makeText(context, "There is error in trip creation", Toast.LENGTH_SHORT).show();
        }
        
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

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
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
