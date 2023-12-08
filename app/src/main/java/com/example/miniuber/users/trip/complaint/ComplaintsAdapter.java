package com.example.miniuber.users.trip.complaint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniuber.R;
import com.example.miniuber.users.Complaint;
import com.example.miniuber.users.Trip;
import com.example.miniuber.users.trip.PreviousTripsAdapter;

import java.util.ArrayList;

public class ComplaintsAdapter extends RecyclerView.Adapter<ComplaintsAdapter.ViewHolder> {

    Context context;
    ArrayList<Complaint> complaintArrayList;

    public ComplaintsAdapter(Context context, ArrayList<Complaint> complaintArrayList) {
        this.context = context;
        this.complaintArrayList = complaintArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.complaint_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintsAdapter.ViewHolder holder, int position) {
            Complaint complaint=complaintArrayList.get(position);
            holder.ComplaintText.setText(complaint.getComplaintText());
            holder.ComplaintDate.setText(complaint.getComplaintText());
    }

    @Override
    public int getItemCount() {
        return complaintArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ComplaintDate,ComplaintText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           ComplaintDate=itemView.findViewById(R.id.complaintDate);
           ComplaintText=itemView.findViewById(R.id.complaintText);

        }
    }
}


