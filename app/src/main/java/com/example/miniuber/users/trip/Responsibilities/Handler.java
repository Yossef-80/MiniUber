package com.example.miniuber.users.trip.Responsibilities;

import com.google.android.material.textfield.TextInputEditText;

public abstract class Handler {
       TextInputEditText field;
    private Handler next;

    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;

    }
    public  abstract boolean handle();


    protected  boolean handleNext()
    {
        if(next==null)
        {
            return  true;
        }
        return next.handle();
    }
}
