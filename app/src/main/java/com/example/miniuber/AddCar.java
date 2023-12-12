package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.employee.Employee;
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
        Employee employee=new Employee();
        AddCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car car=new Car();
                car.setYear(carYear.getText().toString());
                car.setModel(carModel.getText().toString());
                car.setManufacturer(carManufacturer.getText().toString());
                car.setHasOwner(false);
                int carId=employee.AddCar(car,AddCar.this);
                Toast.makeText(AddCar.this, "car id: "+carId, Toast.LENGTH_SHORT).show();
            }
        });



    }

}