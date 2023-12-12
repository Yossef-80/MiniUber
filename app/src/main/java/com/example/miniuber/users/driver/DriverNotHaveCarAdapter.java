package com.example.miniuber.users.driver;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniuber.AvailableCarsToAssign;
import com.example.miniuber.ChangeCar;
import com.example.miniuber.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class DriverNotHaveCarAdapter extends RecyclerView.Adapter<DriverNotHaveCarAdapter.ViewHolder> {
    Context context;
    ArrayList<Driver> driverArrayList;
    boolean changeCar;
    public DriverNotHaveCarAdapter(Context context, ArrayList<Driver> driverArrayList,boolean changeCar) {
        this.context = context;
        this.driverArrayList = driverArrayList;
        this.changeCar=changeCar;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.driver_card,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Driver driver=driverArrayList.get(position);
        holder.DriverPhone.setText(driver.getMobilePhone());
        holder.DriverName.setText(driver.getName());
        holder.DriverEmail.setText(driver.getEmail());
        if(changeCar)
            holder.AssignBtn.setText("Change car");
        holder.AssignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(changeCar)
                {
                     intent=new Intent(context, ChangeCar.class);

                }
                else {
                     intent=new Intent(context, AvailableCarsToAssign.class);

                }
                intent.putExtra("driver_id",driver.getId());
                context.startActivity(intent);
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
