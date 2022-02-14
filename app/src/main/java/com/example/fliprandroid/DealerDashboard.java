package com.example.fliprandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.fliprandroid.Adapters.DriverDetailsAdapter;
import com.example.fliprandroid.Models.DriverDetailsModel;
import com.example.fliprandroid.databinding.ActivityDealerDashboardBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DealerDashboard extends AppCompatActivity {
    private ActivityDealerDashboardBinding dealerDashboardBinding;
    private List<DriverDetailsModel> arraylist;
    private DriverDetailsAdapter driverDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dealerDashboardBinding = ActivityDealerDashboardBinding.inflate(getLayoutInflater());
        setContentView(dealerDashboardBinding.getRoot());
        Bundle bundle=getIntent().getExtras();


        getData();

        arraylist = new ArrayList<>();
        dealerDashboardBinding.driverDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dealerDashboardBinding.driverDetailsRecyclerView.setHasFixedSize(true);


    }

    private void getData() {

        String url = "https://d2d-backend-personnel.herokuapp.com/api/authDriver/allDrivers";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

//                Log.d("tag", response.toString());
                try {
                    for (int i = 0; i < response.length(); i++){

                        JSONObject object = (JSONObject) response.get(i);
                        String name = object.getString("name");
                        int mobile = object.getInt("mobileNumber");
                        int experience = object.getInt("experience");
                        String fromCity1 = object.getString("fromCity1");
                        String toCity1 = object.getString("toCity1");
                        String fromCity2 = object.getString("fromCity2");
                        String toCity2 = object.getString("toCity2");
                        String fromCity3 = object.getString("fromCity3");
                        String toCity3 = object.getString("toCity3");

                        Log.d("tag", name);
                        Log.d("tag", mobile + "");
                        Log.d("tag", experience + "");

                        DriverDetailsModel driverDetailsModel = new DriverDetailsModel(name, experience, mobile, fromCity1, toCity1, fromCity2, toCity2, fromCity3, toCity3);
                        arraylist.add(driverDetailsModel);
                    }

                    driverDetailsAdapter = new DriverDetailsAdapter(getApplicationContext(), arraylist);
//                   driverDetailsAdapter.setHasStableIds(true);
                    dealerDashboardBinding.driverDetailsRecyclerView.setAdapter(driverDetailsAdapter);
                } catch (JSONException e){
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