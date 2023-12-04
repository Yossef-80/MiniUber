package com.example.miniuber.users;

public class Admin extends User implements Registeration {
    @Override
    public boolean Login(String userName, String password) {
        //TODO -admin login
        return false;
    }

    @Override
    public boolean Register(String name, String email, String password, String mobilePhone) {
        //TODO -admin  registers driver to the system
        return false;
    }
}
