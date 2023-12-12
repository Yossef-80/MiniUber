package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.driver.Driver;
import com.example.miniuber.users.employee.Employee;
import com.example.miniuber.users.trip.Responsibilities.ConfirmPassword;
import com.example.miniuber.users.trip.Responsibilities.EmailExistanceHandler;
import com.example.miniuber.users.trip.Responsibilities.EmailHandler;
import com.example.miniuber.users.trip.Responsibilities.Handler;
import com.example.miniuber.users.trip.Responsibilities.PasswordHandler;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterDriver extends AppCompatActivity {
    TextInputLayout carModel,carManufacturer,carYear;
    TextInputEditText carModelEditText,carManufacturerEditText,carYearEditText;
    TextInputEditText name,email,password,confirmPassword,mobile;
    MaterialButton CreateDriverAccBtn;
    SwitchMaterial hasACar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        hasACar=findViewById(R.id.HaveCarSwitch);
        CreateDriverAccBtn=findViewById(R.id.CreateAccount);

        name=findViewById(R.id.register_name_field);
        email=findViewById(R.id.register_email_field);
        password=findViewById(R.id.register_password_field);
        confirmPassword=findViewById(R.id.register_confirm_password_field);
        mobile=findViewById(R.id.register_phone_field);
        carModel=findViewById(R.id.registerCarModel);
        carManufacturer=findViewById(R.id.register_car_manufacturer);
        carYear=findViewById(R.id.register_car_year);

        carModelEditText=findViewById(R.id.registerCarModelField);
        carYearEditText=findViewById(R.id.register_car_manufacturer_year);
        carManufacturerEditText=findViewById(R.id.register_car_manufacturer_field);
        Employee employee=new Employee();

        CreateDriverAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler=new EmailHandler(email);
                    handler.setNextHandler(new EmailExistanceHandler(email,RegisterDriver.this)).setNextHandler(new PasswordHandler(password)).setNextHandler(new ConfirmPassword(password,confirmPassword));
                    if(hasACar.isChecked())
                    {
                        if(carManufacturerEditText.getText().toString().length()>1&&carModelEditText.getText().toString().length()>1&&carYearEditText.getText().toString().length()==4)
                        {
                            Car car=new Car();
                            car.setYear(carYearEditText.getText().toString());
                            car.setModel(carModelEditText.getText().toString());
                            car.setManufacturer(carManufacturerEditText.getText().toString());
                            car.setHasOwner(true);
                            if(handler.handle())
                            {
                                Driver driver=new Driver();
                                driver.setEmail(email.getText().toString());
                                driver.setPassword(password.getText().toString());
                                driver.setName(name.getText().toString());
                                driver.setOwnACar(hasACar.isChecked());
                                driver.setHasACar(hasACar.isChecked());
                                driver.setRate(0);
                                driver.setMobilePhone(mobile.getText().toString());
                                int carId=employee.AddCar(car,RegisterDriver.this);
                                driver.setCarID(carId);
                                employee.RegisterDriver(driver,RegisterDriver.this);

                            }

                        }
                        else{
                            Toast.makeText(RegisterDriver.this, "Missing Fields", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        if(handler.handle())
                        {
                            Driver driver=new Driver();
                            driver.setEmail(email.getText().toString());
                            driver.setPassword(password.getText().toString());
                            driver.setName(name.getText().toString());
                            driver.setOwnACar(hasACar.isChecked());
                            driver.setHasACar(hasACar.isChecked());
                            driver.setRate(0);
                            driver.setMobilePhone(mobile.getText().toString());
                            employee.RegisterDriver(driver,RegisterDriver.this);
                        }
                    }

            }
        });
        hasACar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasACar.isChecked())
                {
                 carModel.setVisibility(View.VISIBLE);
                 carManufacturer.setVisibility(View.VISIBLE);
                 carYear.setVisibility(View.VISIBLE);
                }
                else{
                    carModel.setVisibility(View.GONE);
                    carManufacturer.setVisibility(View.GONE);
                    carYear.setVisibility(View.GONE);
                }
            }
        });






    }

}