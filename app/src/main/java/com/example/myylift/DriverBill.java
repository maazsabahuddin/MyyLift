package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DriverBill extends AppCompatActivity {


    TextView b ;
    Button d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_bill);

        b = findViewById(R.id.FirstCustomer);
         d = findViewById(R.id.billGeneration);
        DataBaseHelper db = new DataBaseHelper(this);

        String c = db.getcustomername(Integer.toString(MainActivity.customerid));

        b.setText(c);

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(DriverBill.this,DriverPersonBill.class);
                startActivity(a);
            }
        });









    }
}
