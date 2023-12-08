package com.example.miniuber.users.trip;

import android.content.Context;
import android.location.Address;
import android.widget.Toast;

public class TripProxy implements TripCreation {
    private static  int NumberOfRequests;
    private Trip trip;


    @Override
    public void CreateTrip(Address pickPoint, Address destination, Context context) {
            if(NumberOfRequests>1)
            {
                Toast.makeText(context, "there is 1 Trip Already booked", Toast.LENGTH_LONG).show();
            }
            else {
                if (trip==null)
                {
                    trip=new Trip();
                }
                trip.CreateTrip(pickPoint,destination,context);
                NumberOfRequests++;
            }
    }
}
