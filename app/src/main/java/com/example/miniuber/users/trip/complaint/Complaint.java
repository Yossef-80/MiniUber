package com.example.miniuber.users.trip.complaint;

import com.example.miniuber.users.User;

public class Complaint {
    private int userId;
    private String ComplaintText;
    private String ComplaintDate;

    public int getUser() {
        return userId;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }

    public String getComplaintText() {
        return ComplaintText;
    }

    public void setComplaintText(String complaintText) {
        ComplaintText = complaintText;
    }

    public String getComplaintDate() {
        return ComplaintDate;
    }

    public void setComplaintDate(String complaintDate) {
        ComplaintDate = complaintDate;
    }
}

