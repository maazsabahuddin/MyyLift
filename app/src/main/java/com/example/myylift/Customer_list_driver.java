package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Customer_list_driver extends AppCompatActivity {



    ListView listt;
    String [] start={"johar","Naziabad"};
    String [] drive={"1","2"};

    String [] end={"Malir","cantt"};
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list_driver);
        db = new DataBaseHelper(this);
        String ar = customerhome.areacustomer;

        String [] dstart = db.getdriverstartt(ar).toArray(new String[0]);
        String [] dend = db.getdriverendd(ar).toArray(new String[0]);
        String [] did = db.getdriveid(ar).toArray(new String[0]);




        listt= (ListView) findViewById(R.id.list);

        list ll = new list(this,dstart,did,dend);
        Toast.makeText(Customer_list_driver.this ,"inserted" +did+ "  This"+ar , Toast.LENGTH_LONG).show();

        listt.setAdapter(ll);

        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent n=new Intent(Customer_list_driver.this,customer_request.class);
                startActivity(n);

            }
        });

    }
}
