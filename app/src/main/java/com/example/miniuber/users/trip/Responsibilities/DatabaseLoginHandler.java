package com.example.miniuber.users.trip.Responsibilities;

import static android.content.Context.MODE_PRIVATE;

import static com.example.miniuber.database.UberDBHelper.sharedPrefFile;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.miniuber.users.User;

public class DatabaseLoginHandler extends Handler{
    User user;
    String username,password;
    Context context;

    public DatabaseLoginHandler(User user, String username, String password,Context context) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.context=context;
    }

    @Override
    public boolean handle() {
        if(!user.Login(username,password,context))
        {
            Toast.makeText(context, "the user name of password may be wrong", Toast.LENGTH_LONG).show();
            return false;
        }
        user.setEmail(username);
        user.setPassword(password);
        user.saveUserData(context);
        Toast.makeText(context, "the login succeeded", Toast.LENGTH_LONG).show();


        return true;
    }
}
