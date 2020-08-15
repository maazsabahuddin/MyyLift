package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DriverApprove extends AppCompatActivity {

    TextView nc;
    TextView pc;
    TextView ic;
    Button b;
    DataBaseHelper db;
    Button c;
    public static String ap ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_approve);

     db = new DataBaseHelper(this);

        nc = findViewById(R.id.NameOfCustomer);
        pc = findViewById(R.id.phnnocustomer);
        ic = findViewById(R.id.IDcustomer);
        b = findViewById(R.id.approval);




        Cursor cursor = db.customerdata(MainActivity.em);
        String x;
        String y;
        String z;

        x = cursor.getString(0);
        y=cursor.getString(1);
        z=cursor.getString(2);

        nc.setText(x);
        pc.setText(y);
        ic.setText(z);

        insert();








    }

    public void insert()
    {
       db = new DataBaseHelper(this);
        b = findViewById(R.id.approval);
        c = findViewById(R.id.cancellation);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ap = "Approved";

                db.insertrides(Driverhome.strl,Driverhome.endl,Integer.toString(Driverhome.pay),Driverhome.did,MainActivity.customerid);
                Intent i = new Intent(DriverApprove.this,DriverBill.class);
                startActivity(i);

            }


        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ap = "Denied";


            }
        });




    }
}
