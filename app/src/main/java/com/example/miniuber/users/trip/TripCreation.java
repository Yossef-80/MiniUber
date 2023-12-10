package com.example.miniuber.users.trip;

import android.content.Context;
import android.location.Address;

public interface TripCreation {
    public void CreateTrip(Address pickPoint,Address destination,String tripDate, Context context);
}
