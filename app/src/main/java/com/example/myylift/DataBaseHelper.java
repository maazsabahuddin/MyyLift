package com.example.myylift;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static int mainid=0;

    public static final String DATABASE_NAME = "yolooo.db";
    public static final String TABLE_NAME = "user_table";





    public static final String USER_ID = "ID";//COMMON COLUMNS

    public static final String USER_NAME = "USERNAMETEXT";
    public static final String PASS = "PASSWORDTEXT";
    public static final String MAIL = "EMAILTEXT";
    public static final String ISWHAT = "ISDRIVERTEXT";

    public static final String TABLE_NAME1 = "customer_table";
    public static final String ID = "ID";
    public static final String NAME = "NAMETEXT";//COMMON NAMES OF CUSTOMER AND DRIVER
    public static final String PHONE = "PHONETEXT";
    public static final String CNIC = "CNICTEXT";

    public static final String TABLE_NAME2 = "driver_table";

    public static final String CARNO = "NUMBER_PLATE";

    public static final String TABLE_NAME3 = "rides_table";
    public static final String DriverID = "DRIVERID";
    public static final String StartLoc = "STARTLOCATION";//COMMON NAMES OF CUSTOMER AND DRIVER
    public static final String EndLoc = "ENDLOCATION";
    public static final String CusID = "CUSTOMERID";
    public static final String Payment = "Payment";

    public static final String TABLE_NAME4 = "Driver_Ride";



    public final String CREATE_TABLE_USER="create table "+ TABLE_NAME + "(" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + USER_NAME + "TEXT," + PASS +"TEXT,"+ MAIL + "TEXT ," + ISWHAT + "TEXT" + ")";

    public final String CREATE_TABLE_CUSTOMER="create table "+ TABLE_NAME1 + "(" + USER_ID + " INTEGER NOT NULL," + NAME + "TEXT," + PHONE +"TEXT,"+ CNIC+ "TEXT PRIMARY KEY , FOREIGN KEY ("+ USER_ID + ") REFERENCES " + TABLE_NAME +"("+USER_ID + "))";

   public final String CREATE_TABLE_DRIVER="create table "+ TABLE_NAME2 + "(" + USER_ID + " INTEGER NOT NULL ,"
            + NAME + "TEXT," + PHONE +"TEXT,"+ CNIC+ "TEXT PRIMARY KEY ," + CARNO+"TEXT, FOREIGN KEY ("+ USER_ID + ") REFERENCES " + TABLE_NAME +"("+USER_ID + "))";


   public final String CREATE_TABLE_RIDES="create table "+ TABLE_NAME3 + "(" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
            + StartLoc + " TEXT, " + EndLoc + " TEXT ,"+Payment+" TEXT,"+DriverID+" INTEGER,"+CusID+" INTEGER, FOREIGN KEY (" + DriverID + ") REFERENCES "+ TABLE_NAME2 +"("+USER_ID +"), FOREIGN KEY (" + CusID + ") REFERENCES " + TABLE_NAME1 + "("+USER_ID + "))";

   public final String CREATE_TABLE_DRIVERRID="create table "+ TABLE_NAME4 + "(" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,"
            + StartLoc + " TEXT, " + EndLoc + " TEXT ,"+DriverID+" INTEGER, FOREIGN KEY (" + DriverID + ") REFERENCES "+ TABLE_NAME2 +"("+USER_ID +"))";




    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //3rd argument to be passed is CursorFactory instanc}}
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        Log.d("here","agai");


        db.execSQL(CREATE_TABLE_DRIVERRID);

                     db.execSQL(CREATE_TABLE_USER);
                     db.execSQL(CREATE_TABLE_CUSTOMER);
                      db.execSQL(CREATE_TABLE_DRIVER);

        db.execSQL(CREATE_TABLE_RIDES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (newVersion > oldVersion)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        onCreate(db);

    }

    public boolean insertrides(String startloc , String endloc , String pay , int driverid , int customerid)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(StartLoc,startloc);
        contentvalues.put(EndLoc,endloc);
        contentvalues.put(Payment,pay);
        contentvalues.put(DriverID,driverid);
        contentvalues.put(CusID,customerid);
        long result = db.insert(TABLE_NAME3,null,contentvalues);
        db.close();
        if (result==0)

            return false;
        else
            return true;

    }

    public boolean insertdriveride(String startloc , String endloc , int driverid)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(StartLoc,startloc);
        contentvalues.put(EndLoc,endloc);
        contentvalues.put(DriverID,driverid);
        long result = db.insert(TABLE_NAME4,null,contentvalues);
        db.close();
        if (result==0)

            return false;
        else
            return true;

    }

    public boolean insertuserdata(String uname , String pass , String email , String driver)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put("USERNAMETEXTTEXT",uname);
        contentvalues.put("PASSWORDTEXTTEXT",pass);
        contentvalues.put("EMAILTEXTTEXT",email);
        contentvalues.put("ISDRIVERTEXTTEXT",driver);
        long result = db.insert(TABLE_NAME,null,contentvalues);
        db.close();
        if (result==0)

            return false;
        else
            return true;

    }



    public boolean insertcustomerdata(int id, String name , String phone , String cnic )
    {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(ID,id);
        contentvalues.put("NAMETEXTTEXT",name);
        contentvalues.put("PHONETEXTTEXT",phone);
        contentvalues.put("CNICTEXTTEXT"
                ,cnic);
        long result = db.insert(TABLE_NAME1,null,contentvalues);
        db.close();
        if (result==0)

            return false;
        else
            return true;

    }

    public boolean insertdrverdata(int id, String name , String phone , String cnic ,String np )
    {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(ID,id);
        contentvalues.put("NAMETEXTTEXT",name);
        contentvalues.put("PHONETEXTTEXT",phone);
        contentvalues.put("CNICTEXTTEXT",cnic);
        contentvalues.put("NUMBER_PLATETEXT",np);
        long result = db.insert(TABLE_NAME2,null,contentvalues);
        db.close();
        if (result==0)

            return false;
        else
            return true;

    }
    public ArrayList getdrivers(String driverid,String area)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arraydriver=new ArrayList<>();

        Cursor cursor=db.rawQuery("SELECT "+USER_ID+","+EndLoc+" FROM"+TABLE_NAME4+" WHERE DRIVERID =? AND STARTLOCATION =?",new String[]{driverid,area});
         cursor.moveToFirst();
         while (!cursor.isAfterLast()) {

             arraydriver.add(cursor.getString(cursor.getColumnIndex("DRIVERID")));
             arraydriver.add(cursor.getString(cursor.getColumnIndex("ENDLOCATION")));
             cursor.moveToNext();

         }
         return arraydriver;


         }

   public int getid(){
       SQLiteDatabase db = this.getWritableDatabase();
       int id=0;

              Cursor res = db.rawQuery("SELECT ID FROM " +TABLE_NAME+" WHERE ID = (select MAX(ID) from user_table)",null);
              res.moveToFirst();
                Log.d("checking",""+res.getInt(0));

                mainid=res.getInt(0);
                id=res.getInt(0);
              return  id;

   }
   public boolean getids ()
   {
       Log.d("data", "yol1o");
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor res = db.rawQuery("SELECT ID FROM " +TABLE_NAME+"",null);
       res.moveToFirst();
       try{
           Log.d("data", "datahere"+res.getInt(0));


           while (res.moveToNext()) {
               Log.d("data", "datahere"+res.getInt(0));

           }
           res.close();
       }
       catch (Exception e)
       {
           Log.d("Error", e.toString());
       }

       return true;
   }

   public boolean userllogin(String email,String password,String captain){

       SQLiteDatabase db = this.getReadableDatabase();
       Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME+" WHERE EMAILTEXTTEXT =? AND PASSWORDTEXTTEXT =? AND ISDRIVERTEXTTEXT =?",new String[]{email,password,captain});

       if (res.getCount() > 0) {

           return true;
       }
       else {
           return false;
       }
   }
    public boolean userlogin(String email,String password,String customer){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME+" WHERE EMAILTEXTTEXT =? AND PASSWORDTEXTTEXT =? AND ISDRIVERTEXTTEXT =?",new String[]{email,password,customer});

        if (res.getCount() > 0) {

            return true;
        }
        else {
            return false;
        }
    }
    public int getdriverid(String  a){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME+" WHERE EMAILTEXTTEXT =?",new String[]{a});
        res.moveToFirst();
        Log.d("checking",""+res.getInt(0));

         int dravid=res.getInt(0);
        dravid=res.getInt(0);
        return  dravid;

    }
    public String getdriverstart(String  d){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME4+" WHERE STARTLOCATION =?",new String[]{d});
        res.moveToFirst();
        Log.d("checking",""+res.getInt(0));

        String str=res.getString(1);
        String end=res.getString(2);
        int didd=res.getInt(4);
        return  str;
    }

    public String getcustomername(String  d){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME1+" WHERE ID =?",new String[]{d});
        res.moveToFirst();
        Log.d("checking",""+res.getInt(0));

        String str=res.getString(1);
        ///String end=res.getString(2);
        //int didd=res.getInt(4);
        return  str;

    }
    public String getdriverend(String  d){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME4+" WHERE STARTLOCATION =?",new String[]{d});
        res.moveToFirst();
        Log.d("checking",""+res.getInt(4));

        String str=res.getString(1);
        String end=res.getString(2);
        int didd=res.getInt(4);

        return  end;

    }

    public int getdriveradd(String  d){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME4+" WHERE STARTLOCATION =?",new String[]{d});
        res.moveToFirst();
        Log.d("checking",""+res.getInt(4));

        String str=res.getString(1);
        String end=res.getString(2);
        int didd=res.getInt(4);

        return  didd;

    }
    public ArrayList<String> getdriverstartt(String  d){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME4+" WHERE STARTLOCATION =?",new String[]{d});

        ArrayList<String> results = new ArrayList<String>();
        if(res.moveToFirst())
        {
            do
            {
                results.add(res.getString(1)); // instead of 0 Index of Category column in your case
            }while(res.moveToNext());
            if(res != null && !res.isClosed())
                res.close();
        }
        return results;
    }

    public ArrayList<String> getdriverendd(String  d){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME4+" WHERE STARTLOCATION =?",new String[]{d});

        ArrayList<String> results = new ArrayList<String>();
        if(res.moveToFirst())
        {
            do
            {
                results.add(res.getString(2)); // instead of 0 Index of Category column in your case
            }while(res.moveToNext());
            if(res != null && !res.isClosed())
                res.close();
        }


        return results;
    }

    public ArrayList<String> getdriveid(String  d){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME4+" WHERE STARTLOCATION =?",new String[]{d});

        ArrayList<String> results = new ArrayList<String>();
        if(res.moveToFirst())
        {
            do
            {
                results.add(Integer.toString(res.getInt(3))); // instead of 0 Index of Category column in your case
            }while(res.moveToNext());
            if(res != null && !res.isClosed())
                res.close();
        }


        return results;
    }


    public String getdrivernumplate(String  a){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME2+" WHERE ID=?",new String[]{a});
        res.moveToFirst();
        Log.d("checking",""+res.getInt(2));

        String dravid;
        dravid=res.getString(2);
        return  dravid;

    }

    public Cursor customerdata(String a){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " +TABLE_NAME+" WHERE EMAILTEXTTEXT=?",new String[]{a});
       cursor.moveToFirst();
        return cursor;

    }

    public String getpay(String a , String b){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME3+" WHERE DRIVERID =? AND CUSTOMERID =?",new String[]{a,b});
        res.moveToFirst();
        Log.d("checking",""+res.getInt(4));

        String str=res.getString(1);
        String end=res.getString(2);
        String didd=res.getString(3);

        return  didd;

    }
}
