package com.example.demoapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.awt.font.NumericShaper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import android.app.Activity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {
    ArrayList<Map<String,Object>> data=new ArrayList<>();
    EditText name,rollno,searchRoll;
    TextView textView;

    static Context context;
    RadioGroup genderRadioGroup;
    String year;



//    int gender=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
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
        genderRadioGroup=findViewById(R.id.gender);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        List<String> year = new ArrayList<String>();
        year.add("Select one");
        year.add("first Year");
        year.add("second year");
        year.add("Third year");
        year.add("Final year");

        ArrayAdapter<String> adapter = new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,year);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);



//        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                int checkedId=radioGroup.getCheckedRadioButtonId();
//                if (checkedId==R.id.male){
//                    gender=1;
//                }else{
//                    gender=2;
//                }
//
//            }
//        });
    }

    public void addData(){
        Map<String,Object> obj=new HashMap<>();
        obj.put("name",name.getText().toString());
        obj.put("rollno",Integer.parseInt(rollno.getText().toString()));
        int id=genderRadioGroup.getCheckedRadioButtonId();
        if(id!=-1) {
            obj.put("gender", id==R.id.male?1:2);
        }

        obj.put("year", year);
        data.add(obj);
        name.setText("");
        rollno.setText("");
        genderRadioGroup.clearCheck();


    }

    public void searchData(){
        int roll=Integer.parseInt(searchRoll.getText().toString());
        for(Map<String,Object> obj:data){
            if(((int)obj.get("rollno"))==(roll)){
                textView.setText(obj.toString());
            } else{
                toast();
            }
        }
    }

    public void toast(){
        Toast.makeText(this,"no data found",Toast.LENGTH_LONG).show();
    }


    public void onClick(View view) {
        if(view.getId()==R.id.btn){
            addData();
        } else if(view.getId()==R.id.search){
            searchData();
        } else{
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        year = adapterView.getItemAtPosition(i).toString();

        Toast.makeText(this,year,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}