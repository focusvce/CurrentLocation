package com.thenewboston.currentlocation;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*public class MainActivity extends AppCompatActivity {

    /*GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         gps = new GPSTracker(this);
        if(gps.canGetLocation())
            Toast.makeText(this,"GPS ENABLED",Toast.LENGTH_LONG).show();
        else
            gps.showSettingsAlert();
        double lat=gps.getLatitude();
        double longi=gps.getLongitude();
        Log.e("LAT LONG",Double.toString(lat)+"   "+Double.toString(longi));
        TextView la = new TextView(this);
        la.setText(Double.toString(lat));
        TextView lo = new TextView(this);
        lo.setText(Double.toString(longi));
    }

    @Override
    public void onBackPressed() {
        gps.stopUsingGPS();
        super.onBackPressed();
    }
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
    LocationManager locationManager;
    private Context context;
    private Activity activity;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private View view;
    GPSTracker gps;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gps = new GPSTracker(this);
        latitude = gps.getLatitude();
        longitude = gps.getLongitude();
        Log.e("LAT LONG", Double.toString(latitude) + "   " + Double.toString(longitude));


        context = getApplicationContext();
        activity = this;
        Button check_permission = (Button)findViewById(R.id.check_permission);
        Button request_permission = (Button)findViewById(R.id.request_permission);
        /*check_permission.setOnClickListener(this);
        request_permission.setOnClickListener(this);

    }


    public void check(View v) {


                if (checkPermission()) {

                    Toast.makeText(this,"Permission already granted.",Toast.LENGTH_LONG).show();
                    gps = new GPSTracker(this);
                    latitude = gps.getLatitude();
                    longitude = gps.getLongitude();
                    Log.e("LAT LONG", Double.toString(latitude) + "   " + Double.toString(longitude));

                } else {

                    Toast.makeText(this,"Please request permission.",Toast.LENGTH_LONG).show();
                }



        }
    public void request(View v)
    {
        if (!checkPermission()) {

            requestPermission();

        } else {

            Toast.makeText(this,"Permission already granted.",Toast.LENGTH_LONG).show();

        }
    }


    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED){

            return true;

        } else {

            return false;

        }
    }

    private void requestPermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)){

            Toast.makeText(context,"GPS permission allows us to access location data. Please allow in App Settings for additional functionality.",Toast.LENGTH_LONG).show();


        } else {

            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "Permission Granted, Now you can access location data.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(this, "Permission Denied, You cannot access location data.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }


}*/
public class MainActivity extends Activity {

    Button btnShowLocation;

    // GPSTracker class
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSTracker(MainActivity.this);

                // check if GPS enabled
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }

            }
        });
    }

}
