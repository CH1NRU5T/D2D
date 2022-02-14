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
import com.example.fliprandroid.databinding.ActivityDealerSignUpBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class DealerSignUp extends AppCompatActivity {
    private ActivityDealerSignUpBinding activityDealerSignUpBinding;
    private String natureOfMaterial;
    private String weightOfMaterial;
    private String quantity;
    private String state;
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDealerSignUpBinding = ActivityDealerSignUpBinding.inflate(getLayoutInflater());
        setContentView(activityDealerSignUpBinding.getRoot());
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        userName = bundle.getString("userName");
        email = bundle.getString("email");
        phoneNumber = bundle.getString("phoneNumber");
        password = bundle.getString("password");
        activityDealerSignUpBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                natureOfMaterial = activityDealerSignUpBinding.natureOfMaterial.getText().toString();
                if (TextUtils.isEmpty(natureOfMaterial)) {
                    activityDealerSignUpBinding.natureOfMaterial.setError("This field cannot be empty");
                    return;
                }
                weightOfMaterial = activityDealerSignUpBinding.weightOfMaterial.getText().toString();
                if (TextUtils.isEmpty(weightOfMaterial)) {
                    activityDealerSignUpBinding.weightOfMaterial.setError("This field cannot be empty");
                    return;
                }
                quantity = activityDealerSignUpBinding.quantity.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    activityDealerSignUpBinding.quantity.setError("This field cannot be empty");
                    return;
                }
                state = activityDealerSignUpBinding.state.getText().toString();
                if (TextUtils.isEmpty(state)) {
                    activityDealerSignUpBinding.state.setError("This field cannot be empty");
                    return;
                }
                postReq();
            }
        });
    }

    private void postReq() {
//        Make post request to register Dealer
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", name);
            jsonObject.put("nature", natureOfMaterial);
            jsonObject.put("email", email);
            jsonObject.put("mobileNumber", Integer.parseInt(phoneNumber));
            jsonObject.put("weight", Integer.parseInt(weightOfMaterial));
            jsonObject.put("quantity", Integer.parseInt(quantity));
            jsonObject.put("city", "bharuch");
            jsonObject.put("password", password);
            jsonObject.put("state", state);
            jsonObject.put("userType", "dealer");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://d2d-backend-personnel.herokuapp.com/api/authDealer/registerDealer", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("helo", response.toString());
                Toast.makeText(DealerSignUp.this, "200", Toast.LENGTH_SHORT).show();
                Bundle bundle1 = new Bundle();
                try {
                    bundle1.putString("id", response.getString("_id"));
                    Intent intent = new Intent(DealerSignUp.this, DealerDashboard.class);
                    intent.putExtras(bundle1);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DealerSignUp.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        {
            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        }
    }
}