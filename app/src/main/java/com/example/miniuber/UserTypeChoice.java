package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.miniuber.users.UserFactory;
import com.google.android.material.card.MaterialCardView;

public class UserTypeChoice extends AppCompatActivity {
    //SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_choice);
        //
        MaterialCardView EmpCardView=findViewById(R.id.adminCard);
        MaterialCardView DriverCardView=findViewById(R.id.DriverCard);
        MaterialCardView CustomerCardView=findViewById(R.id.CustomerCard);





        EmpCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(UserTypeChoice.this, Login.class);
                intent.putExtra("userType","employee");
                startActivity(intent);

            }
        });
        DriverCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* preferencesEditor.putString("UserType","Driver");
                preferencesEditor.apply();*/

                Intent intent=new Intent(UserTypeChoice.this, Login.class);
                intent.putExtra("userType","driver");

                startActivity(intent);
            }
        });
        CustomerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* preferencesEditor.putString("UserType","Customer");
                preferencesEditor.apply();*/
                Intent intent=new Intent(UserTypeChoice.this, Login.class);
                intent.putExtra("userType","customer");

                startActivity(intent);
            }
        });

    }
}