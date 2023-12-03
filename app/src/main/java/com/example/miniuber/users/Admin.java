package com.example.miniuber.users;

public class Admin extends User  {
    @Override
    public boolean Login(String userName, String password) {
        return false;
    }

}
