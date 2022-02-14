package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fliprandroid.databinding.ActivityDriverDashboardBinding;

public class DriverDashboard extends AppCompatActivity {

    ActivityDriverDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDriverDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        binding.textView.setText(bundle.getString("id"));

    }
}