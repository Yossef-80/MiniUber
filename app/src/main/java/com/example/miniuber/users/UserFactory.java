package com.example.miniuber.users;

import com.example.miniuber.users.customer.Customer;
import com.example.miniuber.users.driver.Driver;
import com.example.miniuber.users.employee.Employee;

public class UserFactory {
    private User userObj;

    public User getUser(String user)
    {
        if(user.equalsIgnoreCase("customer")){
         userObj=new Customer();
         return userObj;
        }
        else if(user.equalsIgnoreCase("driver"))
        {
            userObj=new Driver();
            return userObj;
        }
        else if(user.equalsIgnoreCase("employee"))
        {
            userObj=new Employee();
             return userObj;
        }
        else{
            return null;
        }
    }
}
