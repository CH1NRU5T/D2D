package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fliprandroid.databinding.ActivityDriverSignUpBinding;
import com.google.android.material.textfield.TextInputEditText;

public class DriverSignUp extends AppCompatActivity {
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String route1From;
    private String route1To;
    private String route2From;
    private String route2To;
    private String route3From;
    private String route3To;
    private String truckNumber;
    private String truckCapacity;
    private String transporterName;
    private String drivingExperience;
    ActivityDriverSignUpBinding activityDriverSignUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDriverSignUpBinding = ActivityDriverSignUpBinding.inflate(getLayoutInflater());
        setContentView(activityDriverSignUpBinding.getRoot());
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        userName = bundle.getString("userName");
        email = bundle.getString("email");
        phoneNumber = bundle.getString("phoneNumber");
        password = bundle.getString("password");
        activityDriverSignUpBinding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                truckNumber = activityDriverSignUpBinding.truckNumber.getText().toString();
                truckCapacity = activityDriverSignUpBinding.truckCapacity.getText().toString();
                transporterName = activityDriverSignUpBinding.transporterName.getText().toString();
                drivingExperience = activityDriverSignUpBinding.drivingExperience.getText().toString();
                setContentView(R.layout.driver_routes);
                findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        route1From = ((TextInputEditText) (findViewById(R.id.route1From))).getText().toString();
                        route1To = ((TextInputEditText) (findViewById(R.id.route1To))).getText().toString();
                        route2From = ((TextInputEditText) (findViewById(R.id.route2From))).getText().toString();
                        route2To = ((TextInputEditText) (findViewById(R.id.route2To))).getText().toString();
                        route3From = ((TextInputEditText) (findViewById(R.id.route3From))).getText().toString();
                        route3To = ((TextInputEditText) (findViewById(R.id.route3To))).getText().toString();

                        postreq();
                    }
                });

            }
        });
    }

    private void postreq() {
//        Post request to api to register the user
//        String result = "Name: " + name + "\nUsername: " + userName + "\nEmail: " + email + "\nPhoneNumber: " + phoneNumber + "\nPassword: " + password;
//        String result1 = "\nTruck number: "+truckNumber+"\nTruck Capacity: "+truckCapacity+"\nTransporter Name: "+transporterName+"\nExp: "+drivingExperience;
//        Log.d("driver", route1From);
    }
}