package com.example.miniuber.users.trip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniuber.R;
import com.example.miniuber.users.Trip;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PreviousTripsAdapter extends RecyclerView.Adapter<PreviousTripsAdapter.ViewHolder> {
Context context;
ArrayList<Trip> tripArrayList;


    public PreviousTripsAdapter(Context context,ArrayList<Trip> tripArrayList) {
    this.context=context;
    this.tripArrayList=tripArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Trip trip=tripArrayList.get(position);
        holder.cost.setText(String.valueOf(trip.getCarFare())+"EGP");
        holder.destination.setText(trip.getDestination());
        holder.tripTime.setText(trip.getTripTime());
        holder.pickPoint.setText(trip.getPickPoint());
        holder.RateDriverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ratingBar.getRating();
                //TODO -store in the database rating in trip and update driver rate
            }
        });
    }

    @Override
    public int getItemCount() {
        return tripArrayList.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tripTime,cost,pickPoint,destination;
        MaterialButton RateDriverBtn;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tripTime=itemView.findViewById(R.id.TripTimeField);
            cost=itemView.findViewById(R.id.CarFareField);
            pickPoint=itemView.findViewById(R.id.PickPointField);
            destination=itemView.findViewById(R.id.DestField);
            RateDriverBtn=itemView.findViewById(R.id.RateDriverBtn);
            ratingBar=itemView.findViewById(R.id.ratingBar);
        }
    }
}
