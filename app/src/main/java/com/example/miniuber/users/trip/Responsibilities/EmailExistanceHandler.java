package com.example.miniuber.users.trip.Responsibilities;

import com.google.android.material.textfield.TextInputEditText;

public class EmailExistanceHandler extends Handler{
    public EmailExistanceHandler(TextInputEditText emailText) {
        field=emailText;
    }
    public boolean handle() {
        //TODO -check email existence In database
        return  handleNext();
    }
}
