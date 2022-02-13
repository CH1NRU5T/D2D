package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fliprandroid.databinding.ActivityDealerSignUpBinding;

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
                weightOfMaterial = activityDealerSignUpBinding.weightOfMaterial.getText().toString();
                quantity = activityDealerSignUpBinding.quantity.getText().toString();
                state = activityDealerSignUpBinding.state.getText().toString();
                postReq();
            }
        });
    }

    private void postReq() {
//        Make post request to register Dealer
    }
}