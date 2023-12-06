package com.example.miniuber.users;

public class Complaint {
    private String userId;
    private String ComplaintText;
    private String ComplaintDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

