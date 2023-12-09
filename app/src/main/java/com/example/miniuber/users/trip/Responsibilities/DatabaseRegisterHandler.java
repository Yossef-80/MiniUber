package com.example.miniuber.users.trip.Responsibilities;

import android.content.Context;
import android.widget.Toast;

import com.example.miniuber.users.User;

public class DatabaseRegisterHandler extends Handler{
    Context context;
    User user;
    public DatabaseRegisterHandler(User user, Context context) {
        this.user=user;
        this.context=context;
    }

    @Override
    public boolean handle() {
        //TODO -query to insert record in database
        if(!user.Register(context))
        {
            Toast.makeText(context, "There is error in database", Toast.LENGTH_LONG).show();
            return false;
        }
        return handleNext();
    }
}
