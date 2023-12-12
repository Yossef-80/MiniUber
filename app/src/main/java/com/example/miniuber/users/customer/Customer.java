package com.example.miniuber.users.customer;

import static android.content.Context.MODE_PRIVATE;
import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.widget.Toast;

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
    public void makeComplaint(Context context,String complaintText,String complaintDate)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        SharedPreferences sharedPreferences=context.getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        int customerID = sharedPreferences.getInt("id",0);
        if(!dbHelper.createComplaint(customerID,complaintText,complaintDate))
        {
            Toast.makeText(context, "the complaint assign has problems try again", Toast.LENGTH_SHORT).show();
        }
    }

    public void getData(Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        SharedPreferences sharedPreferences=context.getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        int customerID = sharedPreferences.getInt("id",0);
       Cursor cursor= dbHelper.getCustomerData(customerID);
        Toast.makeText(context, "email is >"+cursor.getString(3), Toast.LENGTH_SHORT).show();
        setId(cursor.getInt(0));
        setName(cursor.getString(1));
       setMobilePhone(cursor.getString(2));
        setEmail(cursor.getString(3));
        setPassword(cursor.getString(4));

    }
    public void Rate(int driver_id,int trip_id,Context context,int rate)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        if(!dbHelper.ratedriver(driver_id,trip_id,rate))
        {
            Toast.makeText(context, "Error in Rating", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public ArrayList<Trip> viewTripsDetails(Context context) {
        SharedPreferences sharedPreferences=context.getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        int customerID = sharedPreferences.getInt("id",0);
        setId(customerID);

        UberDBHelper dbHelper = new UberDBHelper(context);
        ArrayList<Trip> tripArrayList=new ArrayList<>();
       tripArrayList= dbHelper.viewPreviousCustomerTrips(id);
       return tripArrayList;
    }


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
        preferencesEditor.putBoolean("isLogged",true);

        UberDBHelper dbHelper = new UberDBHelper(context);
        int id=dbHelper.getCustomerid(Email);
        this.id=id;
        preferencesEditor.putInt("id",id);

        preferencesEditor.apply();
    }

    public void UpdatePersonalInfo(Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        SharedPreferences sharedPreferences=context.getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        int customerID = sharedPreferences.getInt("id",0);

       if(! dbHelper.updateCustomerPersonalInfo(customerID,name,Email,password,mobilePhone))
       {
           Toast.makeText(context, "Error in data update", Toast.LENGTH_SHORT).show();
       }


    }

}
