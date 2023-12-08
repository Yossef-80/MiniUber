package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.miniuber.users.Complaint;
import com.example.miniuber.users.Trip;
import com.example.miniuber.users.trip.PreviousTripsAdapter;
import com.example.miniuber.users.trip.complaint.ComplaintsAdapter;

import java.util.ArrayList;

public class ShowComplaints extends AppCompatActivity {
    RecyclerView previousTrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_previous_trips);
        previousTrips=findViewById(R.id.recyclerView);
        previousTrips.setLayoutManager(new LinearLayoutManager(ShowComplaints.this));
        previousTrips.setHasFixedSize(true);
        ComplaintsAdapter adapter=new ComplaintsAdapter(ShowComplaints.this,fillComplaints());
        previousTrips.setAdapter(adapter);

    }

    private ArrayList<Complaint> fillComplaints() {
        ArrayList<Complaint> ComplaintList=new ArrayList<>();

        for (int i=0 ;i<10;i++)
        { Complaint complaint=new Complaint();
            complaint.setComplaintDate("Time"+String.valueOf(i));
            complaint.setComplaintText("Dist: "+String.valueOf(i));
            ComplaintList.add(complaint);
        }
        return ComplaintList;
    }
}