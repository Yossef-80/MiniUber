package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.miniuber.users.customer.Customer;
import com.example.miniuber.users.User;
import com.example.miniuber.users.UserFactory;
import com.example.miniuber.users.trip.Responsibilities.ConfirmPassword;
import com.example.miniuber.users.trip.Responsibilities.DatabaseLoginHandler;
import com.example.miniuber.users.trip.Responsibilities.EmailExistanceHandler;
import com.example.miniuber.users.trip.Responsibilities.EmailHandler;
import com.example.miniuber.users.trip.Responsibilities.Handler;
import com.example.miniuber.users.trip.Responsibilities.PasswordHandler;
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
        Intent intent=getIntent();
        String type=intent.getStringExtra("userType");
        if (!type.equalsIgnoreCase("customer"))
        {
            registerButton.setEnabled(false);
            registerButton.setVisibility(View.GONE);
        }



        //create class for customer type
        UserFactory userType=new UserFactory();
   //     SharedPreferences sharedPreferences=getSharedPreferences(type,MODE_PRIVATE);
 //       Toast.makeText(this, sharedPreferences.getString("UserType","").toString(), Toast.LENGTH_SHORT).show();

      // User user=userType.getUser(sharedPreferences.getString("UserType","").toString());
        User user=userType.getUser(type);

       LoginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Handler handler=new EmailHandler(email);
               handler.setNextHandler(new EmailExistanceHandler(email)).setNextHandler(new PasswordHandler(password)).setNextHandler(new DatabaseLoginHandler(user,email.getText().toString(),password.getText().toString(),Login.this));
               handler.handle();
           }
       });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent1=new Intent(Login.this,Register.class);
                    startActivity(intent1);
            }
        });

    }
}