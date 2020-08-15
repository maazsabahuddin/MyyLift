package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Customer_Status extends AppCompatActivity {

    Button b;
    TextView t ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__status);

        t = findViewById(R.id.pendingorapprove);;

        t.setText(DriverApprove.ap);

        b = findViewById(R.id.cusendbtn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Customer_Status.this,customer_review.class);
                startActivity(i);
            }
        });




    }
}
