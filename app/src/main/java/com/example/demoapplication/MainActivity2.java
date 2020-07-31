package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapters.StudentsDataAdapter;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MainActivity mainActivity=(MainActivity) MainActivity.context;
//        TextView textView=findViewById(R.id.text);
//        textView.setText(mainActivity.data.toString());
        RecyclerView stdDataRecyclerView=findViewById(R.id.std_data);
        stdDataRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentsDataAdapter studentsDataAdapter=new StudentsDataAdapter(mainActivity.data);
        stdDataRecyclerView.setAdapter(studentsDataAdapter);
    }
}