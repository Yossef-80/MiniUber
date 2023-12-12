package com.example.miniuber.users.driver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniuber.R;
import com.example.miniuber.users.employee.Employee;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    Context context;
    ArrayList<Car> carArrayList;
    int driver_id;
    boolean changeCar;

    public CarAdapter(Context context, ArrayList<Car> carArrayList,int driver_id,boolean changeCar) {
        this.context = context;
        this.carArrayList = carArrayList;
        this.driver_id=driver_id;
        this.changeCar=changeCar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cars_card,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car=carArrayList.get(position);
        holder.CarManu.setText(car.getManufacturer());
        holder.CarModel.setText(car.getModel());
        holder.CarYear.setText(car.getYear());
        holder.AssignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee=new Employee();
                if(changeCar)
                {
                    if(employee.ChangeDriverCar(car,driver_id,context)) {
                        Toast.makeText(context, "Car changed Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    if(employee.assignCarToDriver(car,driver_id,context)) {
                        Toast.makeText(context, "Car assigned Successfully", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return carArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView CarManu,CarModel,CarYear;
        MaterialButton AssignBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            CarManu=itemView.findViewById(R.id.carManuText);
            CarModel=itemView.findViewById(R.id.carModelText);
            CarYear=itemView.findViewById(R.id.carYearText);
            AssignBtn=itemView.findViewById(R.id.carAssignButton);


        }
    }
}
