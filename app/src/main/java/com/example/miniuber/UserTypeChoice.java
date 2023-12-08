package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.miniuber.users.UserFactory;
import com.google.android.material.card.MaterialCardView;

public class UserTypeChoice extends AppCompatActivity {
    public static String sharedPrefFile ="com.example.android.MiniUber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_choice);
          SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        //
        MaterialCardView EmpCardView=findViewById(R.id.adminCard);
        MaterialCardView DriverCardView=findViewById(R.id.DriverCard);
        MaterialCardView CustomerCardView=findViewById(R.id.CustomerCard);

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();




        EmpCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencesEditor.putString("UserType","employee");
                preferencesEditor.apply();

                Intent intent=new Intent(UserTypeChoice.this, BookCar.class);
                startActivity(intent);

            }
        });
        DriverCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencesEditor.putString("UserType","Driver");
                preferencesEditor.apply();

                Intent intent=new Intent(UserTypeChoice.this, ViewPreviousTrips.class);
                startActivity(intent);
            }
        });
        CustomerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencesEditor.putString("UserType","Customer");
                preferencesEditor.apply();
                Intent intent=new Intent(UserTypeChoice.this, Login.class);
                startActivity(intent);
            }
        });

    }
}