package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.miniuber.users.customer.Customer;
import com.example.miniuber.users.trip.Responsibilities.ConfirmPassword;
import com.example.miniuber.users.trip.Responsibilities.DatabaseRegisterHandler;
import com.example.miniuber.users.trip.Responsibilities.EmailExistanceHandler;
import com.example.miniuber.users.trip.Responsibilities.EmailHandler;
import com.example.miniuber.users.trip.Responsibilities.Handler;
import com.example.miniuber.users.trip.Responsibilities.PasswordHandler;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ViewAndUpdateDetails extends AppCompatActivity {
    TextInputEditText Name,Email,Password,Phone,ConfirmPassword;
    TextInputLayout ConfirmPasswordBox;
    MaterialButton SaveBtn,EditBtn,ChangePasswordBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_view_update_details);
          Name=findViewById(R.id.nameEditText);
        Email=findViewById(R.id.editTextTextEmailAddress);
        Password=findViewById(R.id.editPassword);
        Phone=findViewById(R.id.phoneEditText);
        ConfirmPassword=findViewById(R.id.confirmPassword);
        SaveBtn=findViewById(R.id.Savebutton);

        EditBtn=findViewById(R.id.editInfoBtn);
        ChangePasswordBtn=findViewById(R.id.ChangePasswordBtn);
        ConfirmPasswordBox=findViewById(R.id.passwordConfirmLayout);
        Customer customer=new Customer();
        customer.getData(ViewAndUpdateDetails.this);
        //DataBase
        Name.setText(customer.getName());
        Email.setText(customer.getEmail());
        Email.setVisibility(View.GONE);
        Password.setText(customer.getPassword());
        ConfirmPassword.setText(customer.getPassword());
        Phone.setText(customer.getMobilePhone());
      //  Toast.makeText(this, "Email"+customer.getEmail()+" Name "+customer.getName(), Toast.LENGTH_SHORT).show();
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Name.isEnabled())
                {
                    customer.setName(Name.getText().toString());
                    customer.setEmail(Email.getText().toString());
                    customer.setPassword(Password.getText().toString());
                    customer.setMobilePhone(Phone.getText().toString());


                        Handler handler=new EmailHandler(Email);
                        handler.setNextHandler(new PasswordHandler(Password)).setNextHandler(new ConfirmPassword(Password,ConfirmPassword));

                        if(  handler.handle()){
                            customer.UpdatePersonalInfo(ViewAndUpdateDetails.this);
                            Toast.makeText(ViewAndUpdateDetails.this, "Data Updated successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }



                }
                //then click edit button to focus on all fields then save saves data in database from textbox


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
               ConfirmPasswordBox.setVisibility(View.VISIBLE);
               ConfirmPassword.setEnabled(true);
            }
        });



    }
}