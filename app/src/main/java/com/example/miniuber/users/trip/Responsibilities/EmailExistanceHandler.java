package com.example.miniuber.users.trip.Responsibilities;

import android.content.Context;
import android.widget.Toast;

import com.example.miniuber.database.UberDBHelper;
import com.google.android.material.textfield.TextInputEditText;

public class EmailExistanceHandler extends Handler{
    Context context;
    public EmailExistanceHandler(TextInputEditText emailText, Context context) {
        field=emailText;
        this.context=context;
    }
    public boolean handle() {
        // TODO -check email existence In database
        UberDBHelper dbHelper = new UberDBHelper(context);
        boolean isfound=dbHelper.isTheEmailMade(field.getText().toString());
        if (isfound)
        {
            Toast.makeText(context, "there is account created with this email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  handleNext();
    }
}
