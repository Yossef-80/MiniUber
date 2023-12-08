package com.example.miniuber.users;

import android.content.Context;
import android.location.Address;

public interface TripCreation {
    public void CreateTrip(Address pickPoint, Address destination, Context context);
}
