package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class EmployeeMainPage extends AppCompatActivity {
    MaterialButton registerDriverBtn,addCarBtn,assignCarBtn,changeCarBtn,viewComplaintBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_main_page);
      registerDriverBtn=findViewById(R.id.RegisterNewDriverButton);//TODO -chain Of Responsibility Needed
      addCarBtn=findViewById(R.id.AddCarsBtn);
      assignCarBtn=findViewById(R.id.AssignCarTodriverBtn);
      changeCarBtn=findViewById(R.id.ChangeDriverCarBtn);
      viewComplaintBtn=findViewById(R.id.ViewCustomerComplaintsBtn);



      registerDriverBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(EmployeeMainPage.this, RegisterDriver.class);
              startActivity(intent);
          }
      });
      addCarBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(EmployeeMainPage.this, AddCar.class);
              startActivity(intent);
          }
      });
      assignCarBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(UserTypeChoice.this, BookCar.class);
              startActivity(intent);
          }
      });
      changeCarBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(UserTypeChoice.this, BookCar.class);
              startActivity(intent);
          }
      });
      viewComplaintBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(UserTypeChoice.this, BookCar.class);
              startActivity(intent);
          }
      });



    }
}