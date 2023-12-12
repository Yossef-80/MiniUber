package com.example.miniuber.users.trip.Responsibilities;

import android.content.Context;
import android.widget.Toast;

import com.example.miniuber.users.User;
import com.example.miniuber.users.customer.Customer;

public class CustomerDatabaseRegisterHandler extends Handler{
    Context context;
    Customer user;
    public CustomerDatabaseRegisterHandler(Customer user, Context context) {
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
