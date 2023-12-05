package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.miniuber.users.trip.TripFacade;
import com.google.android.material.button.MaterialButton;

public class BookCarActivity extends AppCompatActivity {

    private SearchView pickPoint,destination;
    private MaterialButton pickTimeBtn,ConfirmBtn;
    Address pickPointAd,destinationAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_car);

        pickPoint =findViewById(R.id.mapSearch);
        destination=findViewById(R.id.DestinationSearch);
        pickTimeBtn=findViewById(R.id.timeButton);
        ConfirmBtn=findViewById(R.id.confirmButton);
        TripFacade tripFacade = new TripFacade();
        pickPoint.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                 pickPointAd = tripFacade.getCoordinates(query, BookCarActivity.this);

                    Toast.makeText(BookCarActivity.this, " address "+pickPointAd.getAddressLine(0), Toast.LENGTH_LONG).show();



                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        destination.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                 destinationAd= tripFacade.getCoordinates(query,BookCarActivity.this);
                Toast.makeText(BookCarActivity.this, "address: "+destinationAd.getAddressLine(0), Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        pickTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               tripFacade.CalcTripTime(BookCarActivity.this);
            }
        });
        ConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tripFacade.CreateTrip(pickPointAd,destinationAd);
            }
        });

    }
}