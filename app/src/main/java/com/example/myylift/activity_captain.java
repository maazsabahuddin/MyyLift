package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_captain extends AppCompatActivity {
    DataBaseHelper db;
    EditText dname;
    EditText dphone;
    EditText dcnic;
    EditText dnp;

    Button dregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain);
        db = new DataBaseHelper(this);
        dname = findViewById(R.id.dname);
        dphone = findViewById(R.id.dphone);
        dcnic = findViewById(R.id.dcnic);
        dnp = findViewById(R.id.dnp);
        dregister = findViewById(R.id.dregister);
        adddriver();





    }
    public void adddriver()
    {
        dregister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.getid();
                        int ress = DataBaseHelper.mainid;

                        boolean inserted = db.insertdrverdata(ress,dname.getText().toString(),dphone.getText().toString(),dcnic.getText().toString(),dnp.getText().toString());

                        if (inserted==true)
                        {
                            Toast.makeText(activity_captain.this ,"inserted" +ress+ "  This" , Toast.LENGTH_LONG).show();
                            Intent i = new Intent(activity_captain.this,MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {Toast.makeText(activity_captain.this ,"not inserted"+ress+ "", Toast.LENGTH_LONG).show();
                        }
                    }
                }


        );
    }


}
