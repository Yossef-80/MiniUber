package com.example.miniuber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        ArrayList<Complaint> ComplaintList=new ArrayList<>();

        for (int i=0 ;i<10;i++)
        { Complaint complaint=new Complaint();
            complaint.setComplaintDate("20/11/"+String.valueOf(i));
            complaint.setComplaintText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eu enim consequat, interdum tellus et, blandit erat. Nullam quis dolor risus. Integer eget tincidunt elit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur sagittis, metus vel vulputate tristique, sem ex posuere diam, lobortis rhoncus erat metus ac nisi. Morbi a metus sed lorem cursus malesuada sed et dui. Integer et diam euismod, porttitor urna in, consequat diam. Fusce est ex, hendrerit sed elit at, mattis auctor dolor. Aliquam pellentesque a erat sed suscipit. Curabitur efficitur ut libero aliquet porta.");
            ComplaintList.add(complaint);
        }
        return ComplaintList;
    }
}