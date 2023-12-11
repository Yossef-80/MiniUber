package com.example.miniuber.users.trip.complaint;

import android.content.Context;
import android.widget.Toast;

import com.example.miniuber.BookCar;
import com.example.miniuber.users.customer.Customer;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ComplaintFacade {
    public void createComplaint(String input, Context context)
    {
        Complaint complaint=new Complaint();
        complaint.setComplaintText(input);
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String Sdate=String.valueOf(year)+"/"+String.valueOf(month+1)+"/"+String.valueOf(day);
        complaint.setComplaintDate(Sdate);

        Customer customer=new Customer();
        customer.makeComplaint(context,complaint.getComplaintText(),complaint.getComplaintDate());
        Toast.makeText(context, complaint.getComplaintDate(), Toast.LENGTH_SHORT).show();
    }
}
