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
import com.example.miniuber.users.customer.Customer;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PreviousTripsAdapter extends RecyclerView.Adapter<PreviousTripsAdapter.ViewHolder> {
Context context;
ArrayList<Trip> tripArrayList;
int CustomerOrDriver;
boolean viewBtn;

    public PreviousTripsAdapter(Context context,ArrayList<Trip> tripArrayList,int CustomerOrDriver,boolean viewBtn) {
    this.context=context;
    this.tripArrayList=tripArrayList;
    this.CustomerOrDriver=CustomerOrDriver;
    this.viewBtn=viewBtn;
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
        if(CustomerOrDriver==1){     //customer
            holder.RateDriverBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int rate=(int)holder.ratingBar.getRating();
                    Customer customer=new Customer();
                    customer.Rate(trip.getDriver(),trip.getId(),context, rate);
                    //TODO -store in the database rating in trip and update driver rate
                }
            });

        }
        else if(CustomerOrDriver==2) {//driver
            if (!viewBtn)
            {
                holder.RateDriverBtn.setVisibility(View.GONE);
            }
            holder.RateDriverBtn.setText("Accept Trip");

            holder.ratingBar.setVisibility(View.GONE);
        }

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
