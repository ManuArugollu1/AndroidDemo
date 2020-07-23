package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Map<String,String>> data=new ArrayList<>();
    EditText name,rollno,searchRoll;
    TextView textView;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        textView=findViewById(R.id.text);
        name=findViewById(R.id.name);
        rollno=findViewById(R.id.rollno);
        searchRoll=findViewById(R.id.get);
        Button button=findViewById(R.id.btn);
        Button search=findViewById(R.id.search);
        Button allDataBtn=findViewById(R.id.all_data);
        button.setOnClickListener(this);
        search.setOnClickListener(this);
        allDataBtn.setOnClickListener(this);
    }

    public void addData(){
        Map<String,String> obj=new HashMap<>();
        obj.put("name",name.getText().toString());
        obj.put("rollno",rollno.getText().toString());
        data.add(obj);
        name.setText("");
        rollno.setText("");
    }

    public void searchData(){
        String roll=searchRoll.getText().toString();
        for(Map<String,String> obj:data){
            if(obj.get("rollno").equalsIgnoreCase(roll)){
                textView.setText(obj.toString());
            } else{
                toast();
            }
        }
    }

    public void toast(){
        Toast.makeText(this,"no data found",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn){
            addData();
        } else if(view.getId()==R.id.search){
            searchData();
        } else{
            Intent intent=new Intent(this,MainActivity2.class);
//            intent.putExtra("reference", (Parcelable) this);
            startActivity(intent);
        }
    }
}