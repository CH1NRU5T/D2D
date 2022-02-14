package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fliprandroid.databinding.ActivityDealerDashboardBinding;

public class DealerDashboard extends AppCompatActivity {
    private ActivityDealerDashboardBinding dealerDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dealerDashboardBinding = ActivityDealerDashboardBinding.inflate(getLayoutInflater());
        setContentView(dealerDashboardBinding.getRoot());
        Bundle bundle=getIntent().getExtras();

        dealerDashboardBinding.textView.setText(bundle.getString("id"));
    }
}