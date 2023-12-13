package com.example.miniuber.users.trip;

import android.content.Context;
import android.widget.Toast;

import com.example.miniuber.users.driver.Driver;

public class AcceptTripProxy implements AcceptTrip{
    private static  int NumberOfAcceptance=0;
    @Override
    public void AcceptTrip(Context context, int driver_id) {
        if(NumberOfAcceptance>=1)
        {
            Toast.makeText(context, "You have already accepted a trip", Toast.LENGTH_LONG).show();
        }
        else {
            Driver driver=new Driver();

            driver.AcceptTrip(context,driver_id);
            Toast.makeText(context, "trip Accepted", Toast.LENGTH_SHORT).show();
            NumberOfAcceptance++;
        }
    }
}
