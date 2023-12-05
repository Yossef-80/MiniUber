package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.miniuber.users.User;
import com.example.miniuber.users.UserFactory;
import com.google.android.material.card.MaterialCardView;

public class loginChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_choice);
        //
        MaterialCardView EmpCardView=findViewById(R.id.adminCard);
        MaterialCardView DriverCardView=findViewById(R.id.DriverCard);
        MaterialCardView CustomerCardView=findViewById(R.id.CustomerCard);

        //create class for customer type
        UserFactory userType=new UserFactory();


        EmpCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(loginChoice.this, BookCarActivity.class);
                startActivity(intent);
            }
        });
        DriverCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginChoice.this, ViewPreviousTrips.class);
                startActivity(intent);
            }
        });

    }
}