package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.fliprandroid.databinding.ActivityDriverSignUpBinding;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class DriverSignUp extends AppCompatActivity {
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String age;
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
                if (TextUtils.isEmpty(truckNumber)) {
                    activityDriverSignUpBinding.truckNumber.setError("Truck number cannot be empty");
                    return;
                }
                truckCapacity = activityDriverSignUpBinding.truckCapacity.getText().toString();
                if (TextUtils.isEmpty(truckCapacity)) {
                    activityDriverSignUpBinding.truckCapacity.setError("Truck number cannot be empty");
                    return;
                }
                age = activityDriverSignUpBinding.age.getText().toString();
                if (TextUtils.isEmpty(age)) {
                    activityDriverSignUpBinding.age.setError("Truck number cannot be empty");
                    return;
                }
                transporterName = activityDriverSignUpBinding.transporterName.getText().toString();
                if (TextUtils.isEmpty(transporterName)) {
                    activityDriverSignUpBinding.transporterName.setError("Truck number cannot be empty");
                    return;
                }
                drivingExperience = activityDriverSignUpBinding.drivingExperience.getText().toString();
                if (TextUtils.isEmpty(drivingExperience)) {
                    activityDriverSignUpBinding.drivingExperience.setError("Truck number cannot be empty");
                    return;
                }
                setContentView(R.layout.driver_routes);
                findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        route1From = ((TextInputEditText) (findViewById(R.id.route1From))).getText().toString();
                        if (TextUtils.isEmpty(route1From)) {
                            ((TextInputEditText) (findViewById(R.id.route1From))).setError("This field cannot be empty");
                            return;
                        }
                        route1To = ((TextInputEditText) (findViewById(R.id.route1To))).getText().toString();
                        if (TextUtils.isEmpty(route1From)) {
                            ((TextInputEditText) (findViewById(R.id.route1To))).setError("This field cannot be empty");
                            return;
                        }
                        route2From = ((TextInputEditText) (findViewById(R.id.route2From))).getText().toString();
                        if (TextUtils.isEmpty(route1From)) {
                            ((TextInputEditText) (findViewById(R.id.route2From))).setError("This field cannot be empty");
                            return;
                        }
                        route2To = ((TextInputEditText) (findViewById(R.id.route2To))).getText().toString();
                        if (TextUtils.isEmpty(route1From)) {
                            ((TextInputEditText) (findViewById(R.id.route2To))).setError("This field cannot be empty");
                            return;
                        }
                        route3From = ((TextInputEditText) (findViewById(R.id.route3From))).getText().toString();
                        if (TextUtils.isEmpty(route1From)) {
                            ((TextInputEditText) (findViewById(R.id.route3From))).setError("This field cannot be empty");
                            return;
                        }
                        route3To = ((TextInputEditText) (findViewById(R.id.route3To))).getText().toString();
                        if (TextUtils.isEmpty(route1From)) {
                            ((TextInputEditText) (findViewById(R.id.route3To))).setError("This field cannot be empty");
                            return;
                        }

                        postreq();
                    }
                });

            }
        });
    }

    private void postreq() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", name);
            jsonObject.put("mobileNumber", Integer.parseInt(phoneNumber));
            jsonObject.put("email", email);
            jsonObject.put("age", Integer.parseInt(age));

            jsonObject.put("truckumber", Integer.parseInt(truckNumber));
            jsonObject.put("truckCapacity", truckCapacity);
            jsonObject.put("transporter", transporterName);
            jsonObject.put("experience", drivingExperience);

            jsonObject.put("fromCity1", route1From);
            jsonObject.put("toCity1", route1To);
            jsonObject.put("fromCity2", route2From);
            jsonObject.put("toCity2", route2To);
            jsonObject.put("fromCity3", route3From);
            jsonObject.put("toCity3", route3To);
            jsonObject.put("userType", "driver");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://d2d-backend-personnel.herokuapp.com/api/authDriver/registerDriver", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("helo", response.toString());
                Bundle bundle1 = new Bundle();

                try {
                    bundle1.putString("id", response.getString("_id"));
                    Intent intent = new Intent(DriverSignUp.this, DriverDashboard.class);
                    intent.putExtras(bundle1);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        {
            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        }
    }
}