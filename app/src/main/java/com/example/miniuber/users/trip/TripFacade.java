package com.example.miniuber.users.trip;

import android.app.TimePickerDialog;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.miniuber.users.Trip;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class TripFacade {
       Address address;
       Geocoder geocoder;
       LatLng latLng=null;
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
        public void CalcTripTime(Context context) {
            final Calendar c=Calendar.getInstance();
            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);
            TimeConverter timeConverter=new TimeConverter();
            TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String time=timeConverter.ConvertTo12h(hourOfDay,minute);

                    Toast.makeText(context, "Time set Successfully", Toast.LENGTH_SHORT).show();
                        tripTime=time;
                    // Toast.makeText(context, hourOfDay+" "+minute, Toast.LENGTH_SHORT).show();
                }
            },hour,minute,false);

            timePickerDialog.show();


        }
        public void CreateTrip(String pickPoint,String destination)
        {
            Trip trip=new Trip();
            trip.setCustomer("");
            trip.setTripTime(tripTime);
            trip.setPickPoint(pickPoint);
            trip.setDestination(destination);



        }
}
