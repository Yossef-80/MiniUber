package com.example.miniuber.users.trip;

import android.location.Address;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public class CalcTripDistance {
    //TODO calc trip distance then calc price depend on the
    private double distance;
    public double TripDistance(Address pickPoint,Address destination)
    {
        Location startPoint=new Location("locationA");
        startPoint.setLatitude(pickPoint.getLatitude());
        startPoint.setLongitude(pickPoint.getLongitude());

        Location endPoint=new Location("locationA");
        endPoint.setLatitude(destination.getLatitude());
        endPoint.setLongitude(destination.getLongitude());

         distance=startPoint.distanceTo(endPoint);
        return distance;
    }
    public int calcPrice()
    {
        return (int)distance*3;

    }
}
