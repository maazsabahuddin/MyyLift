package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_customer extends AppCompatActivity {
    DataBaseHelper db;
    EditText name;
    EditText phone;
    EditText cnic;
    Button register;
    public static int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

    int a= Globals.data;
    Globals.data=10;

        db = new DataBaseHelper(this);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        cnic = findViewById(R.id.cnic);
        register = findViewById(R.id.regster);
        addcdata();
    }

    public void addcdata(){
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = db.getid();
                        int res = DataBaseHelper.mainid;

                 //       Log.d("idhere",""+DataBaseHelper.mainid+"    "+res);

                       /* Globals g = (Globals) getApplication();
                        while (res.moveToNext())              {
                            g.setData(res.getInt(0));
                        }

                        id=g.getData(); */



                        boolean inserted = db.insertcustomerdata(res,name.getText().toString(),phone.getText().toString(),cnic.getText().toString());

                        if (inserted==true)
                        {
                            Toast.makeText(activity_customer.this ,"inserted" +res+id+ "  This" , Toast.LENGTH_LONG).show();
                            Intent i =new Intent(activity_customer.this,MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {Toast.makeText(activity_customer.this ,"not inserted"+res+id+ "", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }

}
