package com.example.miniuber.users.trip.Responsibilities;

import android.content.Context;
import android.widget.Toast;

import com.example.miniuber.users.Driver;
import com.example.miniuber.users.User;

public class DatabaseRegisterHandler extends Handler{
    Context context;
    User user;
    public DatabaseRegisterHandler(User driver, Context context) {
        user=driver;
        this.context=context;
    }

    @Override
    public boolean handle() {
        //TODO -query to insert record in database
        if(!user.Register())
        {
            Toast.makeText(context, "There is error in database", Toast.LENGTH_LONG).show();
            return false;
        }
        return handleNext();
    }
}
