package com.example.miniuber.users;

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
