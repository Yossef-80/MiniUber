package com.example.miniuber.users.employee;

import com.example.miniuber.users.driver.Car;
import com.example.miniuber.users.User;

public class Employee extends User {
    @Override
    public boolean Login(java.lang.String userName, java.lang.String password) {
        //TODO -admin login
        return false;
    }

    @Override
    public boolean Register() {
        //TODO -admin  registers driver to the system
        return false;
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
