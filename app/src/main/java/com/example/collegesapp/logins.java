package com.example.collegesapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class logins extends AppCompatActivity implements View.OnClickListener{
    public TextInputLayout fil1,fil2;
    public Button login,signup;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);
        signup=findViewById(R.id.button4);
        signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int ids=v.getId();
        if(ids==R.id.button4){
            Intent intent=new Intent(logins.this,signup.class);
            startActivity(intent);
        }

    }
}