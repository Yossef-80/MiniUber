package com.example.miniuber.users.driver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniuber.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class DriverNotHaveCarAdapter extends RecyclerView.Adapter<DriverNotHaveCarAdapter.ViewHolder> {
    Context context;
    ArrayList<String> driverArrayList;

    public DriverNotHaveCarAdapter(Context context, ArrayList<String> driverArrayList) {
        this.context = context;
        this.driverArrayList = driverArrayList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.driver_card,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String driver=driverArrayList.get(position);
        holder.DriverPhone.setText(driver.getMobilePhone());
        holder.DriverName.setText(driver.getName());
        holder.DriverEmail.setText(driver.getEmail());
        holder.AssignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO -open cars pages with current driver

            }
        });
    }

    @Override
    public int getItemCount() {
        return driverArrayList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView DriverName,DriverPhone,DriverEmail;
        MaterialButton AssignBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            DriverEmail=itemView.findViewById(R.id.driveremail);
            DriverName=itemView.findViewById(R.id.driverName);
            DriverPhone=itemView.findViewById(R.id.drivermobilePhone);
            AssignBtn=itemView.findViewById(R.id.AssignCarBtn);

        }
    }
}
