package com.example.fliprandroid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fliprandroid.Models.DriverDetailsModel;
import com.example.fliprandroid.R;

import java.util.List;

public class DriverDetailsAdapter extends RecyclerView.Adapter<DriverDetailsAdapter.MyViewHolder> {
    private List<DriverDetailsModel> arraylist;
    Context context;

    public DriverDetailsAdapter(Context context, List<DriverDetailsModel> arraylist){
        this.context = context;
        this.arraylist = arraylist;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.driver_details_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final String driverName = arraylist.get(position).getName();
        final int experience = arraylist.get(position).getExperience();
        final int mobile = arraylist.get(position).getMobile();
        final String fromCity1 = arraylist.get(position).getFromCity1();
        final String toCity1 = arraylist.get(position).getToCity1();
        final String fromCity2 = arraylist.get(position).getFromCity2();
        final String toCity2 = arraylist.get(position).getToCity2();
        final String fromCity3 = arraylist.get(position).getFromCity3();
        final String toCity3 = arraylist.get(position).getToCity3();

        holder.name.setText(driverName);
        holder.experience.setText(experience+"");
        holder.mobile.setText(mobile + "");
        holder.fromCity1.setText(fromCity1);
        holder.toCity1.setText(toCity1);
        holder.fromCity2.setText(fromCity2);
        holder.toCity2.setText(toCity2);
        holder.fromCity3.setText(fromCity3);
        holder.toCity3.setText(toCity3);
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, experience, mobile, fromCity1, toCity1, fromCity2, toCity2, fromCity3, toCity3;
        public MyViewHolder(View view) {
            super(view);

            this.name = view.findViewById(R.id.driverName);
            this.experience = view.findViewById(R.id.driverExperience);
            this.mobile = view.findViewById(R.id.driverMobile);
            this.fromCity1 = view.findViewById(R.id.fromCity1);
            this.toCity1 = view.findViewById(R.id.toCity1);
            this.fromCity2 = view.findViewById(R.id.fromCity2);
            this.toCity2 = view.findViewById(R.id.toCity2);
            this.fromCity3 = view.findViewById(R.id.fromCity3);
            this.toCity3 = view.findViewById(R.id.toCity3);

        }
    }
}
