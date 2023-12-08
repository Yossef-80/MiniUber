package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.miniuber.users.customer.Customer;
import com.example.miniuber.users.User;
import com.example.miniuber.users.UserFactory;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextInputEditText email,password;
    MaterialButton LoginButton,registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.editTextEmailAddressField);
        password=findViewById(R.id.editTextPasswordField);
        LoginButton=findViewById(R.id.LoginButton);
        registerButton=findViewById(R.id.RegisterBtn);





        //create class for customer type
        UserFactory userType=new UserFactory();
        SharedPreferences sharedPreferences=getSharedPreferences(UserTypeChoice.sharedPrefFile,MODE_PRIVATE);
 //       Toast.makeText(this, sharedPreferences.getString("UserType","").toString(), Toast.LENGTH_SHORT).show();

        User user=userType.getUser(sharedPreferences.getString("UserType","").toString());
       if(!user.getClass().toString().equals(Customer.class.toString()))
       {
           registerButton.setEnabled(false);
           registerButton.setVisibility(View.GONE);

       }

       LoginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}