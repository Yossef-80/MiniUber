package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.driver.CarAdapter;

import java.util.ArrayList;

public class ChangeCar extends AppCompatActivity {
    RecyclerView Cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_cars);
        Cars=findViewById(R.id.availableCarRecycler);
        Cars.setLayoutManager(new LinearLayoutManager(ChangeCar.this));
        Cars.setHasFixedSize(true);
        CarAdapter adapter=new CarAdapter(ChangeCar.this,fillCars());
        Cars.setAdapter(adapter);
    }
    private ArrayList<Car> fillCars() {
        ArrayList<Car> CarArrayList=new ArrayList<>();

        for (int i=0 ;i<10;i++)
        { Car car=new Car();
            car.setManufacturer("BMW");
            car.setModel("M"+String.valueOf(i));
            car.setYear("201"+String.valueOf(i));
            CarArrayList.add(car);
        }
        return CarArrayList;
    }
}