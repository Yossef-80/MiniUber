package com.example.miniuber.users.trip.Responsibilities;

import com.google.android.material.textfield.TextInputEditText;

public class PasswordHandler extends Handler{
    public PasswordHandler(TextInputEditText passText) {
        field=passText;
    }

    @Override
    public boolean handle() {
        String input=field.getText().toString();
        if(input.length()<8)
        {
            field.setError("The password Should be at least 8 characters");
            return false;
        }
        boolean hasLowerCase=false,hasUpperCase=false,hasNumber=false;
        for (char i :input.toCharArray()) {
            if(Character.isLowerCase(i)) {
                hasLowerCase=true;
            }
            if(Character.isUpperCase(i))
            {
                hasUpperCase=true;
            }
            if (Character.isDigit(i))
            {
                hasNumber=true;
            }
        }
        if(!(hasNumber&&hasLowerCase&&hasUpperCase))
        {
            field.setError("the password should have combination of upper case , lowercase letters and numbers ");
            return false;
        }
        return  handleNext();
    }
}
