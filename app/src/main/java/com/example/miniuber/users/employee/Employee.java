package com.example.miniuber.users.employee;

import static android.content.Context.MODE_PRIVATE;
import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.miniuber.database.UberDBHelper;
import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.User;
import com.example.miniuber.users.driver.Driver;
import com.example.miniuber.users.trip.complaint.Complaint;

import java.util.ArrayList;

public class Employee extends User {
    public ArrayList<Driver> viewDriversNotOwnCar(Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        return dbHelper.viewDriverNotOwnCar();
    }
    public ArrayList<Car> viewAvailableCars(Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        return dbHelper.viewAvailableCars();
    }
    public ArrayList<Driver> viewDriversWithNoCar(Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
       return dbHelper.viewDriverWithNoCar();
    }
    @Override
    public boolean Login(String userName, String password, Context context) {
        UberDBHelper dbHelper = new UberDBHelper(context);

        boolean isRight=dbHelper.LoginEmployee(userName,password);
        return  isRight;
    }


    public boolean RegisterDriver(Driver driver, Context context) {
        UberDBHelper dbHelper = new UberDBHelper(context);
        dbHelper.RegisterDriver(driver.getName(),driver.getMobilePhone(),driver.getEmail(),driver.getPassword(),driver.isOwnACar(),driver.isHasACar(),driver.getCarID(),driver.getRate());
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

    public boolean assignCarToDriver(Car car, int driver,Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);

        return  dbHelper.assignCarToDriver(driver,car.getId());
    }
    public int AddCar(Car car,Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        return dbHelper.AddCar(car.getManufacturer(),car.getModel(), Integer.parseInt(car.getYear()),car.isHasOwner());

    }
    public Boolean ChangeDriverCar(Car newCar, int driver_id,Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        return dbHelper.changeDriverCar(driver_id, newCar.getId());

    }
    public void CreateDemoAcc(Context context)
    {
        UberDBHelper dbHelper = new UberDBHelper(context);
        dbHelper.createDemoEmpAcc();
    }
    public ArrayList<Complaint> ViewComplaints(Context context)
    {
        UberDBHelper dbHelper=new UberDBHelper(context);
        return dbHelper.viewComplaints();
    }

}
