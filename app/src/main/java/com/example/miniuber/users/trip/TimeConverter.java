package com.example.miniuber.users.trip;

public class TimeConverter {
    public String ConvertTo12h(int hours,int minutes)
    {
        String time;
        if(hours>12)
        {
            if(String.valueOf(minutes).length()==1)
            {
                time=hours-12+" : 0"+minutes+" PM" ;

            }
            else{
                time=hours-12+" : "+minutes+" PM" ;

            }

        }
        else{
            if(String.valueOf(minutes).length()==1) {
                time = hours + " : 0" + minutes + " AM";
            }
            else {
                time=hours+" : "+minutes+" AM";
            }
        }
        return time;
    }

}
