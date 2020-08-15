package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class customer_request extends AppCompatActivity {

    TextView nammed;
    TextView phn;
    TextView num;
    DataBaseHelper db;
    Button next;
    public static String p ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_request);

        next = findViewById(R.id.reqtodriver);
        db = new DataBaseHelper(this);

        p = db.getdrivernumplate(list.d);


        nammed = findViewById(R.id.NameOfDriver);
        phn = findViewById(R.id.phnnodriver);
        num = findViewById(R.id.NumPlateDriver);

        nammed.setText(list.s);
        phn.setText(list.d);
        num.setText(p);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(customer_request.this,Customer_Status.class);
                startActivity(i);




            }
        });


    }
}
