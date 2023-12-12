package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miniuber.users.driver.Driver;
import android.os.Bundle;
import android.widget.TextView;

import com.example.miniuber.users.driver.DriverNotHaveCarAdapter;
import com.example.miniuber.users.employee.Employee;


import java.util.ArrayList;

public class ChangeDriverCar extends AppCompatActivity {
    TextView pageTitle;
    RecyclerView Drivers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_not_have_car);
        pageTitle=findViewById(R.id.driverPageTitle);
        pageTitle.setText("Change Driver's Car");

        Drivers=findViewById(R.id.DriverNotHaveCarRecycler);
        Drivers.setLayoutManager(new LinearLayoutManager(ChangeDriverCar.this));
        Drivers.setHasFixedSize(true);
        DriverNotHaveCarAdapter adapter=new DriverNotHaveCarAdapter(ChangeDriverCar.this,fillDrivers(),true);
        Drivers.setAdapter(adapter);


    }
    private ArrayList<Driver> fillDrivers() {

        Employee employee=new Employee();
        return employee.viewDriversNotOwnCar(ChangeDriverCar.this);
    }
}