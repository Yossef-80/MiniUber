package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.miniuber.users.driver.DriverNotHaveCarAdapter;

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
        DriverNotHaveCarAdapter adapter=new DriverNotHaveCarAdapter(ChangeDriverCar.this,fillDrivers());
        Drivers.setAdapter(adapter);


    }
    private ArrayList<String> fillDrivers() {
        ArrayList<String> DriverArrayList=new ArrayList<>();

        for (int i=0 ;i<10;i++)
        { String driver=new String();
            driver.setName("Youssef");
            driver.setMobilePhone("0987654321"+ java.lang.String.valueOf(i));
            driver.setEmail("youssef_haveCar@mail.com");
            DriverArrayList.add(driver);
        }
        return DriverArrayList;
    }
}