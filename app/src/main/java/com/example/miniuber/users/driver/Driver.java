package com.example.miniuber.users.driver;

import static android.content.Context.MODE_PRIVATE;
import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.miniuber.database.UberDBHelper;
import com.example.miniuber.users.User;
import com.example.miniuber.users.trip.Trip;
import com.example.miniuber.users.trip.TripDetails;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User implements TripDetails {


    private boolean OwnACar;
    private boolean hasACar;
    private int carID;
    private String mobilePhone;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    private int rate;

    public boolean isHasACar() {
        return hasACar;
    }

    public void setHasACar(boolean hasACar) {
        this.hasACar = hasACar;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }
    public boolean isOwnACar() {
        return OwnACar;
    }

    public void setOwnACar(boolean ownACar) {
        OwnACar = ownACar;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public boolean Login(String userName, String password, Context context) {
        UberDBHelper dbHelper = new UberDBHelper(context);

        boolean isRight=dbHelper.LoginDriver(userName,password);
        dbHelper.close();
        return  isRight;
    }

    /*@Override
    public boolean Register(Context context) {

        UberDBHelper dbHelper = new UberDBHelper(context);
        boolean isRight=dbHelper.RegisterDriver( name, mobilePhone, Email, password,OwnACar,hasACar, carID,rate);
        return isRight;
    }
*/
    @Override
    public void saveUserData(Context context) {
        SharedPreferences mPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString("UserType","driver");
        preferencesEditor.putBoolean("isLogged",true);

        UberDBHelper dbHelper = new UberDBHelper(context);
        int id=dbHelper.getDriverId(Email);
        this.id=id;

        preferencesEditor.putInt("id",id);

        preferencesEditor.apply();
    }


    @Override
    public ArrayList<Trip> viewTripsDetails(Context context) {
        //TODO -create view trips details
        return null;
    }
    public List<Trip> searchAvailableTrips()
    {
        //TODO -create view trip details
        return null;
    }

}
