package com.example.miniuber.users.trip;

import android.app.Application;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.miniuber.BookCar;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class TripFacade   {
       Address address;
       Geocoder geocoder;
        String tripTime;
        public Address getCoordinates(String query, Context context){
            String location=query.toString();
            List<Address> addressesList=null;
            if(!location.isEmpty())
            {
                geocoder =new Geocoder(context);
                try {
                    addressesList=geocoder.getFromLocationName(location,1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
               address=addressesList.get(0);
              //   latLng=new LatLng(address.getLatitude(),address.getLongitude());
               // Toast.makeText(context, "lat:"+latLng.latitude, Toast.LENGTH_SHORT).show();
            }
            return address;
        }
        public String CalcTripTime(Context context) {
            final Calendar c=Calendar.getInstance();
            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);
            TimeConverter timeConverter=new TimeConverter();
            TimePickerDialog.OnTimeSetListener myTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute1) {

                      //  tripTime=timeConverter.ConvertTo12h(hourOfDay, minute1);

                    tripTime=timeConverter.ConvertTo12h(hour,minute);


                }
            };


            TimePickerDialog timePickerDialog = new TimePickerDialog(context, myTimeSetListener, hour, minute, false);
            timePickerDialog.setTitle("Choose hour:");
         /*  TimePickerDialog timePickerDialog=new TimePickerDialog(context, (view, hourOfDay, minute1) -> {
               if(view.isShown())
               {

               }

               // Toast.makeText(context, "Time set Successfully", Toast.LENGTH_SHORT).show();
                                 // Toast.makeText(context, hourOfDay+" "+minute, Toast.LENGTH_SHORT).show();
            },hour,minute,false);*/
            timePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE,"CONFIRM",timePickerDialog);
            timePickerDialog.show();

            return tripTime;
        }

}
