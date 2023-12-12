package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.miniuber.users.employee.Employee;
import com.example.miniuber.users.trip.complaint.Complaint;
import com.example.miniuber.users.trip.complaint.ComplaintsAdapter;

import java.util.ArrayList;

public class ShowComplaints extends AppCompatActivity {
    RecyclerView previousTrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);
        previousTrips=findViewById(R.id.ComplaintsRecyclerView);
        previousTrips.setLayoutManager(new LinearLayoutManager(ShowComplaints.this));
        previousTrips.setHasFixedSize(true);
        ComplaintsAdapter adapter=new ComplaintsAdapter(ShowComplaints.this,fillComplaints());
        previousTrips.setAdapter(adapter);

    }

    private ArrayList<Complaint> fillComplaints() {
        Employee employee=new Employee();
        return employee.ViewComplaints(ShowComplaints.this);
    }
}