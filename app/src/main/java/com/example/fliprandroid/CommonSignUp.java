package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.fliprandroid.databinding.ActivityCommonSignUpBinding;

import java.util.Objects;

public class CommonSignUp extends AppCompatActivity {
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    ActivityCommonSignUpBinding activityCommonSignUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCommonSignUpBinding = ActivityCommonSignUpBinding.inflate(getLayoutInflater());
        setContentView(activityCommonSignUpBinding.getRoot());


        activityCommonSignUpBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                if (activityCommonSignUpBinding.dealerRadio.isChecked()) {
                    launchActivity(new Intent(CommonSignUp.this, DealerSignUp.class));
                } else if (activityCommonSignUpBinding.driverRadio.isChecked()) {
                    launchActivity(new Intent(CommonSignUp.this, DriverSignUp.class));
                } else {
                    Toast.makeText(CommonSignUp.this, "Please select whether you are a dealer or a driver", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void launchActivity(Intent intent) {
        name = Objects.requireNonNull(activityCommonSignUpBinding.name.getText()).toString();
        userName = Objects.requireNonNull(activityCommonSignUpBinding.userName.getText()).toString();
        email = Objects.requireNonNull(activityCommonSignUpBinding.email.getText()).toString();
        phoneNumber = Objects.requireNonNull(activityCommonSignUpBinding.phoneNumber.getText()).toString();
        password = Objects.requireNonNull(activityCommonSignUpBinding.password.getText()).toString();

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("userName", userName);
        bundle.putString("email", email);
        bundle.putString("phoneNumber", phoneNumber);
        bundle.putString("password", password);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}