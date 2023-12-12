package com.example.miniuber.users;

import android.content.Context;

import com.example.miniuber.Register;

public abstract class  User  {

    protected int id;
    protected String name;
    protected String Email;
    protected String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  abstract boolean Login(String userName, String password, Context context);

    public abstract void saveUserData(Context context);

}
