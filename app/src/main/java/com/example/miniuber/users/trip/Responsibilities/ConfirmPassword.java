package com.example.miniuber.users.trip.Responsibilities;

import com.google.android.material.textfield.TextInputEditText;

public class ConfirmPassword extends Handler{
    TextInputEditText confirmPassText;
    public ConfirmPassword(TextInputEditText passText,TextInputEditText confirmPassText) {
        field=passText;
        this.confirmPassText=confirmPassText;
    }

    @Override
    public boolean handle() {
        if(!confirmPassText.getText().toString().equals(field.getText().toString()))
        {
            confirmPassText.setError("the password doesn't match");
            return false;
        }
        return handleNext();
    }
}
