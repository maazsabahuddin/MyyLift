package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class activity_signup extends AppCompatActivity {

    public static String id;
    DataBaseHelper db;
    EditText Username;
    EditText email;
    EditText pass;
    Spinner what;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

         db = new DataBaseHelper(this);
         Globals g = (Globals) getApplication();


        Username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        what = findViewById(R.id.iswhat);
        next =  findViewById(R.id.next);
        String a = what.getSelectedItem().toString();

        add_data();
    }

    public void add_data(){

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean inserted = db.insertuserdata(Username.getText().toString(),pass.getText().toString(),email.getText().toString(),what.getSelectedItem().toString());

                        if (inserted==true && what.getSelectedItem().toString().equals("Customer"))
                        {Toast.makeText(activity_signup.this ,"inserted" , Toast.LENGTH_LONG).show();
                        Intent i = new Intent(activity_signup.this,activity_customer.class);
                        startActivity(i);
                   }
                        else if (inserted==true && what.getSelectedItem().toString().equals("Captain"))
                        {Toast.makeText(activity_signup.this ,"inserted" , Toast.LENGTH_LONG).show();
                            Intent b = new Intent(activity_signup.this,activity_captain.class);
                            startActivity(b);
                        }


                        else
                        {Toast.makeText(activity_signup.this ,"not inserted" , Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );

    }

    public  void id(){

      /*  Cursor res = db.getid();

        String d = res.getString(0);
*/


    }
}
