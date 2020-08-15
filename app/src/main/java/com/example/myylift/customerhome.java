package com.example.myylift;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class customerhome extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "";
    public static double ll = 0.0;
    public static double ll2 = 0.0;
    public static String areacustomer;

    EditText Area;
    Button next;
    TextView textView;
    EditText t;
    Geocoder geocoder;
    List<Address> addresses;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    Location currentlocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    public static final int Request_Code = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerhome);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        geocoder = new Geocoder(this, Locale.getDefault());

        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {


                if (location != null) {
                    currentlocation = location;

                    ll = currentlocation.getLatitude();
                    ll2 = currentlocation.getLongitude();
                    Toast.makeText(getApplicationContext(), ll + "" + ll2, Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Google_map);
                    supportMapFragment.getMapAsync(customerhome.this);
                    textView = findViewById(R.id.address);

                    // For text view getting aaddress

                    try {
                        addresses = geocoder.getFromLocation(ll, ll2, 1);

                        String addresss = addresses.get(0).getAddressLine(0);
                        String area = addresses.get(0).getLocality();
                        String city = addresses.get(0).getAdminArea();

                        String fulladd = addresss + " , " + area + " , " + city;
                        textView.setText(fulladd);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //textView.setText("this  "+ll+ll2);
                }
            }
        });

        nexttt();


//        Log.d(TAG, "this"+ll2 );
        // textView=findViewById(R.id.address);


        //  textView.setText("this  "+ll+ll2);


    }

    private void fetchLastLocation() {



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

        } else {
            // Permission to access the location is missing. Show rationale and request permission
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();

        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    currentlocation=location;

                    ll= currentlocation.getLatitude();
                    ll2 = currentlocation.getLongitude();
                    Toast.makeText(getApplicationContext(),ll+""+ll2,Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Google_map);
                    supportMapFragment.getMapAsync(customerhome.this);
                }
            }
        });

    }
    @Override
    public void onMapReady(GoogleMap googleMap){

        LatLng latLng=new LatLng(currentlocation.getLatitude(),currentlocation.getLongitude());
        MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("Im here");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
        googleMap.addMarker(markerOptions);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        { case Request_Code:

            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

                fetchLastLocation();
            }
            break;
        }
    }

    public void nexttt(){

        next = findViewById(R.id.cusnext);
        t = findViewById(R.id.cusareaa);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                areacustomer = t.getText().toString();
                Intent cus = new Intent(customerhome.this,Customer_list_driver.class);
                startActivity(cus);


            }
        });
    }
}
