package com.example.miniuber.users;

import com.example.miniuber.Register;

public abstract class  User  {

    private int id;
    private String name;
    private String Email;
    private String password;

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

    public  abstract boolean Login(String userName, String password);
    public abstract boolean Register();


}
