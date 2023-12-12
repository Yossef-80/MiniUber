package com.example.miniuber;

import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.miniuber.users.UserFactory;
import com.example.miniuber.users.employee.Employee;
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

        SharedPreferences sharedPreferences=getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        boolean userIsLogged = sharedPreferences.getBoolean("isLogged",false);
        String userType=sharedPreferences.getString("UserType","");
      //  Employee employee=new Employee();
     //   employee.CreateDemoAcc(UserTypeChoice.this);
        if(userIsLogged&&userType.equalsIgnoreCase("customer"))
        {
            Intent intent=new Intent(UserTypeChoice.this, BookCar.class);
            startActivity(intent);
        }
        else if(userIsLogged&&userType.equalsIgnoreCase("driver"))
        {
            Intent intent=new Intent(UserTypeChoice.this, SearchAvailableTrips.class);
            startActivity(intent);
        }
        else if (userIsLogged&&userType.equalsIgnoreCase("employee"))
        {
            Intent intent=new Intent(UserTypeChoice.this, EmployeeMainPage.class);
            startActivity(intent);
        }


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