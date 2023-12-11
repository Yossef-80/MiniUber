package com.example.miniuber.database;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.miniuber.users.customer.Customer;
import com.example.miniuber.users.trip.Trip;
import com.example.miniuber.users.trip.complaint.Complaint;

import java.util.ArrayList;

public class UberDBHelper extends SQLiteOpenHelper {
    public static String sharedPrefFile ="com.example.android.MiniUber";

    Context context;
    private static String databaseName="MiniUberDB";
    SQLiteDatabase uberDatabase;


    public UberDBHelper(Context context) {
        super(context, databaseName, null, 1);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {




        db.execSQL("create table customer(id integer primary key Autoincrement,"+"name text not null,mobilePhone text not null,email text not null,password text not null )");
       db.execSQL("create table car( id integer primary key Autoincrement," +"manufacturer text not null,model text not null,year number not null,hasOwner boolean not null)");
        db.execSQL("create table driver(id integer primary key Autoincrement,"+"name text not null,mobilePhone text not null,email text not null,password text not null,ownCar boolean not null,hasCar boolean not null,car_id integer,rate integer )");
        db.execSQL("create table employee(id integer primary key Autoincrement,"+"name text not null,email text not null,password text not null)");
        db.execSQL("create table trip(id integer primary key Autoincrement,"+"customer_id integer,driver_id integer,rate integer,pickpoint text,destination text,triptime text ,carfare integer,has_driver boolean)");
        db.execSQL("create table complaints(id integer primary key Autoincrement,"+"user_id integer not null,comp_text text not null,comp_date text not null)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists customer");
        db.execSQL("drop table if exists car");
        db.execSQL("drop table if exists driver");
        db.execSQL("drop table if exists employee");
        db.execSQL("drop table if exists trip");
        db.execSQL("drop table if exists complaints");

        onCreate(db);
    }
    public int getCustomerid(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        String query="select id from customer where email= \""+email+"\"";
        Cursor cursor=null;
        if(db!=null)
        {
            cursor= db.rawQuery(query,null);
        }
        if (cursor != null)
            cursor.moveToFirst();
        assert cursor != null;
        return cursor.getInt(0);
    }
    public int getDriverId(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        String query="select id from driver where email= \""+email+"\"";
        Cursor cursor=null;
        if(db!=null)
        {
            cursor= db.rawQuery(query,null);
        }
            cursor.moveToFirst();
        return cursor.getInt(0);
    }
    public int getEmployeeId(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        String query="select id from employee where email= \""+email+"\"";
        Cursor cursor=null;
        if(db!=null)
        {
            cursor= db.rawQuery(query,null);
        }
        if (cursor != null)
            cursor.moveToFirst();
        return cursor.getInt(0);
    }
    public  boolean LoginCustomer(String email,String password)
    {

        SQLiteDatabase db=this.getReadableDatabase();

            String query="select * from customer where email= \""+email+"\" and password=\""+password+"\"";
        Cursor cursor=null;
        if(db!=null)
        {
           cursor= db.rawQuery(query,null);
        }

        return cursor.getCount()>0;


    }
    public  boolean LoginEmployee(String email,String password)
    {

        SQLiteDatabase db=this.getReadableDatabase();

        String query="select * from employee where email= \""+email+"\" and password=\""+password+"\"";
        Cursor cursor=null;
        if(db!=null)
        {
            cursor= db.rawQuery(query,null);
        }


        return  cursor.getCount()>0;

    }
    public  boolean LoginDriver(String email,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        String query="select * from driver where email= \""+email+"\" and password=\""+password+"\"";
        Cursor cursor=null;
        if(db!=null)
        {
            cursor= db.rawQuery(query,null);
        }
        db.close();

        return cursor.getCount()>0;

    }
    public boolean RegisterCustomer(String name,String mobilePhone,String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("name",name);
        cv.put("mobilePhone",mobilePhone);
        cv.put("email",email);
        cv.put("password",password);
        long results=db.insert("customer",null,cv);
        db.close();

        return results != -1;


    }
    public boolean RegisterDriver(String name,String mobilePhone,String email,String password,boolean ownCar,boolean hasCar,int carId,int rate)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("name",name);
        cv.put("mobilePhone",mobilePhone);
        cv.put("email",email);
        cv.put("password",password);
        cv.put("ownCar",ownCar);
        cv.put("hasCar",hasCar);
        cv.put("car_id",carId);
        cv.put("rate",rate);
        long results=db.insert("driver",null,cv);
        db.close();

        return results != -1;



    }
    //    public boolean CreateTrip(String pickpoint,String destination,String tripTime,int customer_id,int driver_id,int rate,String triptime,int carfare,boolean has_driver)
    public boolean CreateTrip(String pickpoint,String destination,String tripTime,int customer_id,String triptime,int carfare)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("pickpoint",pickpoint);
        cv.put("destination",destination);
        cv.put("tripTime",tripTime);
        cv.put("customer_id",customer_id);
        cv.put("triptime",triptime);
        cv.put("carfare",carfare);
        cv.put("has_driver",false);
        long results=db.insert("trip",null,cv);
        db.close();

        return results != -1;

    }
    //update customer information
    public boolean updateCustomerPersonalInfo(int id, String newName,String newEmail,String password,String newMobilePhone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("name",newName);
        cv.put("mobilePhone",newMobilePhone);
        cv.put("email",newEmail);
        cv.put("password",password);
        long results=db.update("customer",cv,"id=?",new String[]{String.valueOf(id)});
        db.close();

        return results!=-1;
    }
    //rate driver
    public boolean ratedriver(int driverid,int tripid,int rate)
    {
        if(!rateTrip(tripid,rate))
        {
            return false;
        }
        SQLiteDatabase db=this.getReadableDatabase();

        String query="select rate from driver where id= \""+driverid+"\"";
        Cursor cursor=null;
        if(db!=null)
        {
            cursor= db.rawQuery(query,null);
            db.close();
        }
        if(cursor!=null)
        {
            int currRate=cursor.getInt(0);
            int newRate=currRate+rate;
            db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("rate",newRate);
            long results=db.update("driver",cv,"id=?",new String[]{String.valueOf(driverid)});
            return results!=-1;
        }
        return false;

    }
    //rate user trip
    public boolean rateTrip(int tripid,int rate)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("rate",rate);
        long results=db.update("trip",cv,"id=?",new String[]{String.valueOf(tripid)});
        db.close();
        return results!=-1;
    }
   // "create table trip(id integer primary key Autoincrement,"+"customer_id integer,driver_id integer,
    // rate integer,pickpoint text,destination text,triptime text ,carfare integer,has_driver boolean)");

    //view previous trips
    public ArrayList<Trip> viewPreviousCustomerTrips(int customer_id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from trip where customer_id= \""+customer_id+"\" and driver_id is not null";
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);

        ArrayList<Trip>tripArrayList=new ArrayList<>();
        while (cursor.moveToNext())
        {
            Trip trip=new Trip();
            trip.setCustomer(cursor.getInt(1));//customerID
            trip.setDriver(cursor.getInt(2));//DriverID

            trip.setRate(cursor.getInt(3));
            trip.setPickPoint(cursor.getString(4));
            trip.setDestination(cursor.getString(5));
            trip.setTripTime(cursor.getString(6));
            trip.setCarFare(cursor.getInt(7));
            trip.setHasADriver(cursor.getInt(8)>0);


            tripArrayList.add(trip);
        }
        cursor.close();
        return tripArrayList;
    }
    public ArrayList<Trip> viewPreviousDriverTrips(int driver_id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from trip where driver_id= \""+driver_id+"\"";
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        db.close();
        ArrayList<Trip>tripArrayList=new ArrayList<>();
        while (cursor.moveToNext())
        {
            Trip trip=new Trip();
            trip.setCustomer(cursor.getInt(1));//customerID
            trip.setDriver(cursor.getInt(2));//DriverID
            trip.setRate(Integer.parseInt(cursor.getString(3)));
            trip.setPickPoint(cursor.getString(4));
            trip.setDestination(cursor.getString(5));
            trip.setTripTime(cursor.getString(6));
            trip.setCarFare(cursor.getInt(7));
            trip.setHasADriver(cursor.getInt(8)>0);


            tripArrayList.add(trip);
        }
        cursor.close();
        return tripArrayList;
    }
    //"create table complaints(id integer primary key Autoincrement,"+"user_id integer not null,comp_text text not null,comp_date text not null)"
    public boolean createComplaint(int customerId,String complaintText,String complaintDate)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();


        //cv.put("id",complaintId);
        cv.put("user_id",customerId);
        cv.put("comp_text",complaintText);
        cv.put("comp_date",complaintDate);

        long results=db.insert("complaints",null,cv);
        db.close();

        return results != -1;



    }
    //"create table complaints(id integer primary key Autoincrement,"+"user_id integer not null,comp_text text not null,comp_date text not null)"

    public ArrayList<Complaint> viewComplaints()
    {
        ArrayList<Complaint> complaintArrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from complaints";
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        db.close();
       while (cursor.moveToNext())
       {
           Complaint complaint=new Complaint();
           complaint.setUser(cursor.getInt(1));
           complaint.setComplaintText(cursor.getString(2));
           complaint.setComplaintDate(cursor.getString(3));
           complaintArrayList.add(complaint);
       }
       cursor.close();
       return complaintArrayList;

    }
    public ArrayList<Trip> availableTripsForDriver()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from trip where has_driver= "+false;
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        db.close();
        ArrayList<Trip>tripArrayList=new ArrayList<>();
        while (cursor.moveToNext())
        {
            Trip trip=new Trip();
            trip.setCustomer(cursor.getInt(1));//customerID
            trip.setDriver(cursor.getInt(2));//DriverID
            trip.setRate(Integer.parseInt(cursor.getString(3)));
            trip.setPickPoint(cursor.getString(4));
            trip.setDestination(cursor.getString(5));
            trip.setTripTime(cursor.getString(6));
            trip.setCarFare(cursor.getInt(7));
            trip.setHasADriver(cursor.getInt(8)>0);


            tripArrayList.add(trip);
        }
        cursor.close();
        return tripArrayList;

    }
    public boolean isTripAvailableForDriver(int trip_id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from trip where id= "+trip_id;
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        db.close();

        return cursor != null;


    }
    // "create table trip(
    // id integer primary key Autoincrement,"+
    // "customer_id integer
    // driver_id integer,
    // rate integer,
    // pickpoint text,
    // destination text,
    // triptime text ,
    // carfare integer,
    // has_driver boolean)");
    public boolean AcceptTrip(int driver_id,int trip_id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();


        cv.put("driver_id",driver_id);
        cv.put("has_driver",true);


        long results=db.update("trip",cv,"id=?",new String[]{String.valueOf(trip_id)});
        db.close();

        return results != -1;
    }

      //"create table car(
    // id integer primary key Autoincrement,
    // " +"manufacturer text not null,
    // model text not null,
    // year number not null,
    // hasOwner boolean not null)");

    public boolean AddCar(String manufacturer,String model,int year,boolean hasOwner)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();


        cv.put("manufacturer",manufacturer);
        cv.put("model",model);
        cv.put("year",year);
        cv.put("hasOwner",hasOwner);

        long results=db.insert("car",null,cv);
        db.close();

        return results != -1;

    }
    public boolean isDriverHasCar(int driver_id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from driver where id= "+driver_id;
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        db.close();

        return cursor != null;

    }
     //create table driver(id integer primary key Autoincrement,
    // "+"name text not null,
    // mobilePhone text not null,
    // email text not null,
    // password text not null,
    // ownCar boolean not null,
    // hasCar boolean not null,
    // car_id integer
    // ,rate integer )");

    public boolean assignCarToDriver(int driver_id,int car_id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();


        cv.put("car_id",car_id);
        cv.put("hasCar",true);


        long results=db.update("driver",cv,"id=?",new String[]{String.valueOf(driver_id)});
        db.close();

        return results != -1;

    }
    //"create table car(
    // id integer primary key Autoincrement,
    // " +"manufacturer text not null,
    // model text not null,
    // year number not null,
    // hasOwner boolean not null)");

    public boolean changeDriverCar(int driver_id,int new_car_id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select car_id from driver where id= "+driver_id;
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        int old_car_id=cursor.getInt(0);
        cursor.close();

        db.close();
         db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put("car_id",new_car_id);

        long results=db.update("driver",cv,"id=?",new String[]{String.valueOf(driver_id)});

        ContentValues cv2=new ContentValues();
        cv2.put("hasOwner",false);

        long results2=db.update("car",cv2,"id=?",new String[]{String.valueOf(old_car_id)});
        return results != -1 && results2 != -1;

    }
    public boolean isTheEmailMade(String email)
    {

        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from driver where email= \""+email+"\"";
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        boolean foundInDriver=cursor.getCount()>0;

         query="select * from customer where email= \""+email+"\"";

        cursor=null;
        cursor=db.rawQuery(query,null);
        boolean foundInCustomer=cursor.getCount()>0;

        query="select * from employee where email=\""+email+"\"";

        cursor=null;
        cursor=db.rawQuery(query,null);
        boolean foundInEmployee=cursor.getCount()>0;
        return foundInCustomer||foundInDriver||foundInEmployee;
    }
        //"create table customer
    // (id integer primary key Autoincrement
    // ,"+"name text not null,
    // mobilePhone text not null,
    // email text not null,
    // password text not null )");

    public Cursor getCustomerData(int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from customer where id= "+id;
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        return cursor;
    }






}
