package com.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentsDataAdapter extends RecyclerView.Adapter<StudentsDataAdapter.MyViewHolder> {
    ArrayList<Map<String,Object>> data;
    public StudentsDataAdapter(ArrayList<Map<String, Object>> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.row_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Map<String,Object> obj=data.get(position);
        holder.name.setText(""+obj.get("name"));
        holder.roll.setText(""+obj.get("rollno"));
        Number number= (Number) obj.get("gender");
        holder.gender.setText(number.intValue()==1?"Male":"Female");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,roll,gender;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            roll=itemView.findViewById(R.id.rollno);
            gender=itemView.findViewById(R.id.gender);
        }
    }
}
