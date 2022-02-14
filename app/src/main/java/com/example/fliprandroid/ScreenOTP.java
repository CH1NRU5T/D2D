package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.fliprandroid.databinding.ActivityScreenOtpBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class ScreenOTP extends AppCompatActivity {
    ActivityScreenOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScreenOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject1 = new JSONObject();
                EditText otp = findViewById(R.id.otpET);
                try {
                    jsonObject1.put("otp", Integer.parseInt(otp.getText().toString()));
                    Toast.makeText(ScreenOTP.this, otp.getText().toString(), Toast.LENGTH_SHORT).show();
                    JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.POST, "https://d2d-backend-personnel.herokuapp.com/api/authDealer/postOTP", jsonObject1, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            startActivity(new Intent(ScreenOTP.this, DealerDashboard.class));
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    {
                        MySingleton.getInstance(ScreenOTP.this).addToRequestQueue(jsonObjectRequest1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        });
    }
}