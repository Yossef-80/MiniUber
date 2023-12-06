package com.example.miniuber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.Slide;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.miniuber.users.trip.TripFacade;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class BookCarActivity extends AppCompatActivity {

    private SearchView pickPoint,destination;
    private MaterialButton pickTimeBtn,ConfirmBtn;
    private ImageButton menuBtn;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Address pickPointAd,destinationAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_car);

        pickPoint =findViewById(R.id.mapSearch);
        destination=findViewById(R.id.DestinationSearch);
        pickTimeBtn=findViewById(R.id.timeButton);
        ConfirmBtn=findViewById(R.id.confirmButton);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);

        menuBtn=findViewById(R.id.menuBtn);
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

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.ComplaintItem) {

                    drawerLayout.closeDrawer(Gravity.LEFT);

                    AlertDialog.Builder builder= new AlertDialog.Builder(BookCarActivity.this);
                    builder.setTitle("Complaint Title");

                    final EditText input = new EditText(BookCarActivity.this);
                    input.setInputType(InputType.TYPE_CLASS_TEXT);

                    builder.setView(input);
                    builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(BookCarActivity.this, input.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.show();

                }
                 if (item.getItemId()==R.id.logOutItem) {

                        //TODO log out the user
                }
                 if (item.getItemId()==R.id.updateInfoItem) {
                     Intent intent=new Intent(BookCarActivity.this, ViewAndUpdateDetails.class);
                     startActivity(intent);
                }
                if (item.getItemId()==R.id.PreviousTripItem) {
                    Intent intent=new Intent(BookCarActivity.this, ViewPreviousTrips.class);
                    startActivity(intent);
                }


                return true;
            }
        });
    }
}