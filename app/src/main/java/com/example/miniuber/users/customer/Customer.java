package com.example.miniuber.users.customer;

import static android.content.Context.MODE_PRIVATE;
import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.miniuber.database.UberDBHelper;
import com.example.miniuber.users.trip.Trip;
import com.example.miniuber.users.trip.TripDetails;
import com.example.miniuber.users.User;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements TripDetails {
    private String mobilePhone;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public boolean Login(String userName, String password, Context context) {
        UberDBHelper dbHelper = new UberDBHelper(context);

        boolean isRight=dbHelper.LoginCustomer(userName,password);

        return  isRight;
    }


    public void bookCar()
    {
        //TODO -customer books car
    }
    @Override
    public ArrayList<Trip> viewTripsDetails(Context context) {

        UberDBHelper dbHelper = new UberDBHelper(context);
        ArrayList<Trip> tripArrayList=new ArrayList<>();
       tripArrayList= dbHelper.viewPreviousCustomerTrips(id);
       return tripArrayList;
    }

    @Override
    public boolean Register(Context context) {
        UberDBHelper dbHelper = new UberDBHelper(context);
        boolean isRight=dbHelper.RegisterCustomer( name, mobilePhone, Email, password);
        return isRight;
    }

    @Override
    public void saveUserData(Context context) {
        SharedPreferences mPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString("UserType","customer");
        preferencesEditor.apply();
    }

    public boolean UpdatePersonalInfo(String name, String email, String password, String mobilePhone)
    {
        return false;
    }
}
