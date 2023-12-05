package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.miniuber.users.Trip;
import com.example.miniuber.users.trip.PreviousTripsAdapter;

import java.util.ArrayList;

public class ViewPreviousTrips extends AppCompatActivity {
    RecyclerView previousTrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_previous_trips);
        previousTrips=findViewById(R.id.recyclerView);
        previousTrips.setLayoutManager(new LinearLayoutManager(ViewPreviousTrips.this));
        previousTrips.setHasFixedSize(true);
        PreviousTripsAdapter adapter=new PreviousTripsAdapter(ViewPreviousTrips.this,fillTrips());
        previousTrips.setAdapter(adapter);




    }
    //demo
    public ArrayList<Trip> fillTrips()
    {
        ArrayList<Trip> tripArrayList=new ArrayList<>();

        for (int i=0 ;i<10;i++)
        { Trip trip=new Trip();
            trip.setTripTime("Time"+String.valueOf(i));
            trip.setDestination("Dist: "+String.valueOf(i));
            trip.setPickPoint("Pick: "+String.valueOf(i));
            trip.setCarFare(i);
            tripArrayList.add(trip);
        }
        return tripArrayList;
    }
}