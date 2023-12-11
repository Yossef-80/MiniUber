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
        public String  CalcTripTime(Context context) {
            final Calendar c=Calendar.getInstance();
            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);
            TimeConverter timeConverter=new TimeConverter();

            TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour1, int minute1) {
                    BookCar.tripTime=timeConverter.ConvertTo12h(hour1,minute1);
                   // Toast.makeText(context, "Time set to "+tripTime[0], Toast.LENGTH_SHORT).show();

                }
            }, hour, minute, false);

            timePickerDialog.show();

          return  BookCar.tripTime;
        }

}
