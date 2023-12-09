package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.miniuber.users.driver.DriverNotHaveCarAdapter;

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
        DriverNotHaveCarAdapter adapter=new DriverNotHaveCarAdapter(DriverNotHaveCar.this,fillDrivers());
        Drivers.setAdapter(adapter);
    }

    private ArrayList<String> fillDrivers() {
        ArrayList<String> DriverArrayList=new ArrayList<>();

        for (int i=0 ;i<10;i++)
        { String driver=new String();
            driver.setName("Youssef");
            driver.setMobilePhone("0123456789"+ java.lang.String.valueOf(i));
            driver.setEmail("youssef@mail.com");
            DriverArrayList.add(driver);
        }
        return DriverArrayList;
    }
}