package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.miniuber.users.driver.Driver;
import com.example.miniuber.users.trip.PreviousTripsAdapter;
import com.example.miniuber.users.trip.Trip;

import java.util.ArrayList;

public class SearchAvailableTrips extends AppCompatActivity {
    RecyclerView AvailableTrips;
    ImageButton viewPreviousTrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_available_trips);
        AvailableTrips=findViewById(R.id.SearchTripsRecycler);
        viewPreviousTrips=findViewById(R.id.previousTripsBtn);
        AvailableTrips.setLayoutManager(new LinearLayoutManager(SearchAvailableTrips.this));
        AvailableTrips.setHasFixedSize(true);
        PreviousTripsAdapter adapter=new PreviousTripsAdapter(SearchAvailableTrips.this,fillTrips(),2,true);
        AvailableTrips.setAdapter(adapter);
        viewPreviousTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SearchAvailableTrips.this,ViewPreviousTripsDriver.class);
                startActivity(intent);
            }
        });
    }
    public ArrayList<Trip> fillTrips()
    {
        Driver driver=new Driver();
        return  driver.searchAvailableTrips(SearchAvailableTrips.this);
    }
}