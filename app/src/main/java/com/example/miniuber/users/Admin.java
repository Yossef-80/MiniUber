package com.example.miniuber.users;

public class Admin extends User implements Registeration {
    @Override
    public boolean Login(String userName, String password) {
        return false;
    }

    @Override
    public boolean Register(String name, String email, String password, String mobilePhone) {
        return false;
    }
}
