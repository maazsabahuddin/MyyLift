package com.example.myylift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText pass;
    Button login;
    Button signup;

    public static String em;
    public static int driveridfinal;
    public static int customerid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


           DataBaseHelper mydb = new DataBaseHelper(MainActivity.this);

        email = findViewById(R.id.user);
        pass =  findViewById(R.id.pass);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
         userlogin();
         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent j = new Intent(MainActivity.this,activity_signup.class);
                 startActivity(j);
             }
         });




    }

    public void userlogin(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper mydb = new DataBaseHelper(MainActivity.this);


                String  a = email.getText().toString();
                String b = pass.getText().toString();
                String c = "Captain";
                String cs = "Customer";


                boolean userloginn = mydb.userllogin(a,b,c);
                boolean cslogin = mydb.userlogin(a, b, cs);

                if (userloginn == true)
                {
                    Intent i = new Intent(MainActivity.this,HomeFragment.class);
                    startActivity(i);
                   driveridfinal = mydb.getdriverid(a);
                    Toast.makeText(MainActivity.this,"LOGIN SUUCCESSFUL Captain"+driveridfinal+"",Toast.LENGTH_LONG).show();

                }
                else if(cslogin == true) {
                    Intent j = new Intent(MainActivity.this,customerhome.class);
                    startActivity(j);
                        Toast.makeText(MainActivity.this, "LOGIN SUUCCESSFUL Customer", Toast.LENGTH_LONG).show();

                        em = a;
                        customerid = mydb.getdriverid(a);


                }
                else
                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_LONG).show();





            }
        });

    }
}
