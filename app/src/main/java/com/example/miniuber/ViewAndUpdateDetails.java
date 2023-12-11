package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.miniuber.users.customer.Customer;
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
        Password.setText(customer.getPassword());
        Phone.setText(customer.getMobilePhone());
      //  Toast.makeText(this, "Email"+customer.getEmail()+" Name "+customer.getName(), Toast.LENGTH_SHORT).show();
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
               ConfirmPasswordBox.setVisibility(View.VISIBLE);
               ConfirmPassword.setEnabled(true);
            }
        });



    }
}