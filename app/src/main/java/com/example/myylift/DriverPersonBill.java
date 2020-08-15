package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.DatabaseMetaData;

public class DriverPersonBill extends AppCompatActivity {
    DataBaseHelper db ;
    TextView bill ;
    Button r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_person_bill);
        db = new DataBaseHelper(this);
        bill = findViewById(R.id.RSbill);
        r=findViewById(R.id.DriverReview);
        String a;

        a = db.getpay(Integer.toString(MainActivity.driveridfinal),Integer.toString(MainActivity.customerid));

        bill.setText(a);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(DriverPersonBill.this,Driverhome.class);
                startActivity(e);
            }
        });






    }
}
