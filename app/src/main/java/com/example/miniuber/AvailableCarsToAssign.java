package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.driver.CarAdapter;
import com.example.miniuber.users.employee.Employee;

import java.util.ArrayList;

public class AvailableCarsToAssign extends AppCompatActivity {
    RecyclerView Cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_cars);

        Intent intent=getIntent();
        int id=intent.getIntExtra("driver_id",-1);

        Cars=findViewById(R.id.availableCarRecycler);
        Cars.setLayoutManager(new LinearLayoutManager(AvailableCarsToAssign.this));
        Cars.setHasFixedSize(true);
        CarAdapter adapter=new CarAdapter(AvailableCarsToAssign.this,fillCars(),id,false);
        Cars.setAdapter(adapter);
    }

    private ArrayList<Car> fillCars() {
        Employee employee=new Employee();
        return  employee.viewAvailableCars(AvailableCarsToAssign.this);
    }
}