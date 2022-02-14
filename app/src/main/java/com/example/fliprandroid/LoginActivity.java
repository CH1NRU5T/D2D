package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fliprandroid.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;
    private String email;
    private String password;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());

        activityLoginBinding.loginWithPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = activityLoginBinding.email.getText().toString();
                password = activityLoginBinding.password.getText().toString();
                if (TextUtils.isEmpty(password)) {
                    activityLoginBinding.password.setError("Password cannot be Empty");
                    return;
                }
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("email", email);
                    jsonObject.put("password", password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent;

                if (activityLoginBinding.dealerRadio.isChecked()) {
                    url = "https://d2d-backend-personnel.herokuapp.com/api/authDealer/loginDealer";
                    intent = new Intent(LoginActivity.this, DealerDashboard.class);
                } else {
                    url = "https://d2d-backend-personnel.herokuapp.com/api/authDriver/loginDriver";
                    intent = new Intent(LoginActivity.this, DriverDashboard.class);
                }


                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("id", response.get("_id").toString());
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Wrong email or Password", Toast.LENGTH_SHORT).show();
                    }
                });
                {
                    MySingleton.getInstance(LoginActivity.this).addToRequestQueue(jsonObjectRequest);
                }
            }
        });

    }
}