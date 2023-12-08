package com.example.miniuber.users.trip.complaint;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ComplaintFacade {
    public void createComplaint(String input)
    {
        Complaint complaint=new Complaint();
        complaint.setComplaintText(input);
        Date date=new Date();
        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("Africa,Egypt"));
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String Sdate=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
        complaint.setComplaintDate(Sdate);

    }
}
