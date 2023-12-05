package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ViewAndUpdateDetails extends AppCompatActivity {
    TextInputEditText Name,Email,Password,Phone,ConfirmPassword;
    MaterialButton SaveBtn,EditBtn,ChangePasswordBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_and_update_details);

        Name=findViewById(R.id.nameEditText);
        Email=findViewById(R.id.editTextTextEmailAddress);
        Password=findViewById(R.id.editPassword);
        Phone=findViewById(R.id.phoneEditText);

        SaveBtn=findViewById(R.id.Savebutton);

        EditBtn=findViewById(R.id.editInfoBtn);
        ChangePasswordBtn=findViewById(R.id.ChangePasswordBtn);
        //DataBase
        Name.setText("");
        Email.setText("");
        Password.setText("");
        Phone.setText("");

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO read data from database then add to text fields which  aren't focusable
                //then click edit button to focus on all fields then save saves data in database from textbox

                if(Password.getText()!=ConfirmPassword.getText())
                {
                    ConfirmPassword.setError("Password doesn't match");
                }
                else{
                    //TODO write data in database
                }
            }
        });
        EditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name.setEnabled(true);
                Email.setEnabled(true);

                Phone.setEnabled(true);
            }
        });
        ChangePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Password.setEnabled(true);
                ChangePasswordBtn.setVisibility(View.VISIBLE);
            }
        });



    }
}