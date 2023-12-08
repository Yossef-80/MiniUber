package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddCar extends AppCompatActivity {
    TextInputEditText carManufacturer,carYear,carModel;
    MaterialButton AddCarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        carManufacturer=findViewById(R.id.editTextCarManu);
        carYear=findViewById(R.id.editTextCarYear);
        carModel=findViewById(R.id.editTextCarModel);

        AddCarBtn=findViewById(R.id.AddCar);

        AddCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

}