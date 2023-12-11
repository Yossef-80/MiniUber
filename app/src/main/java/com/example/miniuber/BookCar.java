package com.example.miniuber;

import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.miniuber.users.customer.Customer;
import com.example.miniuber.users.trip.TimeConverter;
import com.example.miniuber.users.trip.Trip;
import com.example.miniuber.users.trip.TripCreation;
import com.example.miniuber.users.trip.TripFacade;
import com.example.miniuber.users.trip.TripProxy;
import com.example.miniuber.users.trip.complaint.ComplaintFacade;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

public class BookCar extends AppCompatActivity {

    private SearchView pickPoint,destination;
    private MaterialButton pickTimeBtn,ConfirmBtn;
    private ImageButton menuBtn,backBtn;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Address pickPointAd=null,destinationAd=null;
    public static  String tripTime;
    String[] times;
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
        backBtn=findViewById(R.id.backBtn);
        menuBtn=findViewById(R.id.menuBtn);
        TripFacade tripFacade = new TripFacade();


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        pickPoint.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                    pickPointAd=tripFacade.getCoordinates(query, BookCar.this);


                    Toast.makeText(BookCar.this, " address "+pickPointAd.getAddressLine(0), Toast.LENGTH_LONG).show();



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
                destinationAd= tripFacade.getCoordinates(query, BookCar.this);
                Toast.makeText(BookCar.this, "address: "+destinationAd.getAddressLine(0), Toast.LENGTH_LONG).show();
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


              tripFacade.CalcTripTime(BookCar.this);


            }
        });
        ConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TripCreation tripCreation=new TripProxy();

                if (pickPointAd!=null&&destinationAd!=null&&tripTime!=null)
                {
                    tripCreation.CreateTrip(pickPointAd,destinationAd,tripTime ,BookCar.this);

                }
                else{
                    Toast.makeText(BookCar.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
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

                    AlertDialog.Builder builder= new AlertDialog.Builder(BookCar.this);
                    builder.setTitle("Complaint Title");

                    final EditText input = new EditText(BookCar.this);
                    input.setInputType(InputType.TYPE_CLASS_TEXT);

                    builder.setView(input);
                    builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //TODO -create Complaint
                            ComplaintFacade complaintFacade=new ComplaintFacade();
                            complaintFacade.createComplaint(input.getText().toString(),BookCar.this);


                           // Toast.makeText(BookCar.this, input.getText().toString(), Toast.LENGTH_SHORT).show();
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
                     SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

                     SharedPreferences.Editor preferencesEditor = mPreferences.edit();

                     preferencesEditor.putBoolean("isLogged",false);
                     preferencesEditor.apply();
                     finish();
                }
                 if (item.getItemId()==R.id.updateInfoItem) {
                     Intent intent=new Intent(BookCar.this, ViewAndUpdateDetails.class);
                     startActivity(intent);
                }
                if (item.getItemId()==R.id.PreviousTripItem) {
                    Intent intent=new Intent(BookCar.this, ViewPreviousTrips.class);
                    startActivity(intent);
                }


                return true;
            }
        });
    }
}