package com.example.miniuber.users.trip.Responsibilities;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EmailHandler extends Handler{


    public EmailHandler(TextInputEditText EmailInput) {
        field=EmailInput;
    }

    @Override
    public boolean handle() {
    if(!(field.getText().toString().contains("@yahoo")||field.getText().toString().contains("@gmail")||field.getText().toString().contains("@outlook")))
        {
            field.setError("UnAccepted Domains (use domains like \'gmail\',\'yahoo\',\'outlook\')");
            return false;
        }
        return  handleNext();
    }
}
