package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.miniuber.users.trip.Responsibilities.ConfirmPassword;
import com.example.miniuber.users.trip.Responsibilities.EmailExistanceHandler;
import com.example.miniuber.users.trip.Responsibilities.EmailHandler;
import com.example.miniuber.users.trip.Responsibilities.Handler;
import com.example.miniuber.users.trip.Responsibilities.PasswordHandler;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterDriver extends AppCompatActivity {
    TextInputLayout carModel,carManufacturer,carYear;
    TextInputEditText name,email,password,confirmPassword,mobile;
    MaterialButton CreateDriverAccBtn;
    SwitchMaterial hasACar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        hasACar=findViewById(R.id.HaveCarSwitch);
        CreateDriverAccBtn=findViewById(R.id.CreateAccount);

        name=findViewById(R.id.register_name_field);
        email=findViewById(R.id.register_email_field);
        password=findViewById(R.id.register_password_field);
        confirmPassword=findViewById(R.id.register_confirm_password_field);
        mobile=findViewById(R.id.register_phone_field);
        carModel=findViewById(R.id.registerCarModel);
        carManufacturer=findViewById(R.id.register_car_manufacturer);
        carYear=findViewById(R.id.register_car_year);


        CreateDriverAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler=new EmailHandler(email);
                    handler.setNextHandler(new EmailExistanceHandler(email)).setNextHandler(new PasswordHandler(password)).setNextHandler(new ConfirmPassword(password,confirmPassword));
                handler.handle();
            }
        });
        hasACar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasACar.isActivated())
                {
                 carModel.setVisibility(View.VISIBLE);
                 carManufacturer.setVisibility(View.VISIBLE);
                 carYear.setVisibility(View.VISIBLE);
                }
                else{
                    carModel.setVisibility(View.GONE);
                    carManufacturer.setVisibility(View.GONE);
                    carYear.setVisibility(View.GONE);
                }
            }
        });






    }

}