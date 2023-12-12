package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.miniuber.users.driver.Driver;
import com.example.miniuber.users.driver.DriverNotHaveCarAdapter;
import com.example.miniuber.users.employee.Employee;

import java.util.ArrayList;

public class DriverNotHaveCar extends AppCompatActivity {
    RecyclerView Drivers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_not_have_car);

        Drivers=findViewById(R.id.DriverNotHaveCarRecycler);
        Drivers.setLayoutManager(new LinearLayoutManager(DriverNotHaveCar.this));
        Drivers.setHasFixedSize(true);
        DriverNotHaveCarAdapter adapter=new DriverNotHaveCarAdapter(DriverNotHaveCar.this,fillDrivers(),false);
        Drivers.setAdapter(adapter);
    }

    private ArrayList<Driver> fillDrivers() {
        Employee employee=new Employee();

        ArrayList<Driver> driverArrayList=employee.viewDriversWithNoCar(DriverNotHaveCar.this);

      return driverArrayList;
    }
}