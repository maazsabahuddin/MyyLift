package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class customer_review extends AppCompatActivity {

    TextView l;
    TextView m;
    TextView n;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_review);

        l=findViewById(R.id.NameOfDriver);
        m=findViewById(R.id.phnnodriver);
        n = findViewById(R.id.NumPlateDriver);
        b=findViewById(R.id.review_customer);

        l.setText(list.s);
        m.setText(list.d);
        n.setText(customer_request.p);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(customer_review.this,customerhome.class);
                startActivity(i);
            }
        });




    }
}
