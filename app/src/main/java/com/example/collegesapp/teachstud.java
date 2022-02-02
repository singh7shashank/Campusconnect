package com.example.collegesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class teachstud extends AppCompatActivity implements View.OnClickListener {

    public Button bt1,bt2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachstud);
        bt1=findViewById(R.id.button);
        bt2=findViewById(R.id.button2);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

        int ids=v.getId();
        

        if(ids==R.id.button){

            Intent intent=new Intent(teachstud.this,logint.class);
            startActivity(intent);
        }
        else if(ids==R.id.button2){
            Intent intent=new Intent(teachstud.this,logins.class);
            startActivity(intent);

        }

    }
}