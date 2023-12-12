package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.driver.CarAdapter;
import com.example.miniuber.users.employee.Employee;

import java.util.ArrayList;

public class ChangeCar extends AppCompatActivity {
    RecyclerView Cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_cars);

        Intent intent=getIntent();
        int id=intent.getIntExtra("driver_id",-1);

        Cars=findViewById(R.id.availableCarRecycler);
        Cars.setLayoutManager(new LinearLayoutManager(ChangeCar.this));
        Cars.setHasFixedSize(true);
        CarAdapter adapter=new CarAdapter(ChangeCar.this,fillCars(),id,true);
        Cars.setAdapter(adapter);
       // Toast.makeText(this, "User id"+id, Toast.LENGTH_SHORT).show();
    }
    private ArrayList<Car> fillCars() {
        Employee employee=new Employee();
        return  employee.viewAvailableCars(ChangeCar.this);

    }
}