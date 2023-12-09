package com.example.miniuber.users.employee;

import static android.content.Context.MODE_PRIVATE;
import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.miniuber.database.UberDBHelper;
import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.User;

public class Employee extends User {
    @Override
    public boolean Login(String userName, String password, Context context) {
        UberDBHelper dbHelper = new UberDBHelper(context);

        boolean isRight=dbHelper.LoginEmployee(userName,password);
        return  isRight;
    }

    @Override
    public boolean Register(Context context) {
        //TODO -admin  registers driver to the system
        return false;
    }

    @Override
    public void saveUserData(Context context) {
        SharedPreferences mPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString("UserType","employee");
        preferencesEditor.putBoolean("isLogged",true);

        UberDBHelper dbHelper = new UberDBHelper(context);
        int id=dbHelper.getEmployeeId(Email);
        this.id=id;
        preferencesEditor.putInt("id",id);

        preferencesEditor.apply();

    }

    public Boolean assignCarToDriver(Car car, String driver)
    {
        //TODO -Assign car to driver
        return false;
    }
    public Boolean AddCar(Car car)
    {
        //TODO -Assign car to driver
        return false;
    }
    public Boolean ChangeDriverCar(Car newCar, String driver)
    {
        //TODO -Assign car to driver
        return false;
    }
}
