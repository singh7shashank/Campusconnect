package com.example.collegesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class tsignup extends AppCompatActivity {

   private EditText fname,lname,email,cnfpassword,password;
   private  Spinner gender,university,school;
    private Button signup;
    private  String gendert,universityt,schoolt;
    private String fnameinput,lnameinput,passwdinput,cnfpasswdinput,emailinput;
    private TextView fnamerq,lnamerq,sexrq,unirq,schrq,emailinv,psswdinv,cnfmpsswdinv;
    private CheckBox termscnd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsignup);
        gender=findViewById(R.id.sex);
        university=findViewById(R.id.university);
        school=findViewById(R.id.school);
        fname=findViewById(R.id.firstname);
        lname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cnfpassword=findViewById(R.id.cnfpsswd);
        signup=findViewById(R.id.sinupt);
        fnamerq=findViewById(R.id.fnamerq);
        lnamerq=findViewById(R.id.lnamerq);
        sexrq=findViewById(R.id.sexrq);
        unirq=findViewById(R.id.unirq);
        schrq=findViewById(R.id.schrq);
        emailinv=findViewById(R.id.emailinv);
        psswdinv=findViewById(R.id.psswdinv);
        cnfmpsswdinv=findViewById(R.id.cnfmpsswdinv);
        termscnd=findViewById(R.id.termsandcnd);

        //terms and condition

        boolean useragreed=termscnd.isChecked();
        //ends here



        //gender array adapter

        ArrayAdapter<CharSequence> genderadapter=ArrayAdapter.createFromResource(this,R.array.sex,R.layout.dropdown);
        genderadapter.setDropDownViewResource(R.layout.dropdown);
        gender.setAdapter(genderadapter);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                gendert=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ends here

        //arrayadapter for university

        ArrayAdapter<CharSequence> universityadapter=ArrayAdapter.createFromResource(this,R.array.university,R.layout.dropdown);
        universityadapter.setDropDownViewResource(R.layout.dropdown);
        university.setAdapter(universityadapter);
        university.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                universityt=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ends here


        //arrayadapter school

        ArrayAdapter<CharSequence> schooladapter=ArrayAdapter.createFromResource(this,R.array.school,R.layout.dropdown);
        schooladapter.setDropDownViewResource(R.layout.dropdown);
        school.setAdapter(schooladapter);
        school.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                schoolt=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ends here

        //signup button//

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fnamevalifation();
                lnamevalidatio();
                gendervalidation();
                universutyvalidation();
                schoolvalidation();
                emailvalidation();
                passwordvalidation();

            }
        });

        //ends here

    }

    //fname validation

    boolean  fnamevalifation(){
        fnameinput=fname.getText().toString();

        if(!fnameinput.isEmpty()){

            fnamerq.setText(" ");
            return true;
        }
        else{
            fnamerq.setText("*Required");
            return  false;
        }
    }
    //endhere

    //lname validation
    boolean lnamevalidatio(){

        lnameinput=lname.getText().toString();
        if(!lnameinput.isEmpty()){

            lnamerq.setText(" ");
            return true;
        }
        else {
            lnamerq.setText("*Required");
            return false;
        }

    }
    //ends here

    //sex validation

    boolean gendervalidation(){

        String gs="sex";
        if(gs.equals(gendert)){
            sexrq.setText("*Required");
            return false;
        }
        else{
            sexrq.setText(" ");
            return true;
        }

    }
    //ends here

    //university validation
    boolean universutyvalidation(){
        String uinvs="University";
        if(uinvs.equals(universityt)){
            unirq.setText("*Required");
            return false;
        }
        else{
            unirq.setText(" ");
            return true;
        }


    }
    //ends here

    //school validation

    boolean schoolvalidation(){
        String schs="School";
        if(schs.equals(schoolt)){
            schrq.setText("*Required");
            return false;
        }
        else{
            schrq.setText(" ");
            return true;
        }
    }
    //ends here

    // email validation
    boolean emailvalidation(){

        emailinput=email.getText().toString();
        if(!emailinput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()){
            emailinv.setText(" ");
            return true;
        }
        else{
            emailinv.setText("Invalid E-mail");
            return false;
        }


    }

    //ends here

    //password validation

    boolean passwordvalidation(){

        passwdinput=password.getText().toString();
        cnfpasswdinput=cnfpassword.getText().toString();
        int psswdlen,cnfmpsswdlen;
        psswdlen=passwdinput.length();
        cnfmpsswdlen=cnfpasswdinput.length();

        if (!passwdinput.isEmpty() && !cnfpasswdinput.isEmpty()) {

            if (psswdlen >= 8) {


                if (passwdinput.equals(cnfpasswdinput)) {
                    psswdinv.setText(" ");
                    cnfmpsswdinv.setText(" ");
                    return true;
                }
                else{


                    cnfmpsswdinv.setText("password didn't match");
                    return false;

                }
            } else {
                psswdinv.setText("Weak password");
                return false;
            }

        } else {
            psswdinv.setText("Enter password");
            cnfmpsswdinv.setText("Enter password");
            return false;

        }



    }

    //ends here

}