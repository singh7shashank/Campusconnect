package com.example.collegesapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class signup extends AppCompatActivity {
   private  Spinner spingender, spinuniversity, spinschool, spinsemester;
    private  EditText dateofbirth, emailadd, passwd, passwordcnf, firstname, lastname;
    private  CheckBox termscondition;
    private Button signupbtn;
    private  TextView emailinvali, passwdinvalid, passwdcnfinvalid;
    private TextView fnamerq,lnamerq,sexrq,dorq,unirq,schrq,csrq;
    int year, month, day;
    int pss=1;//passwordvald since boolean didn't work


    //////////variable
    String gender, university, school, semester, emailinput, passwdinput, passwdcnfinput,dateob;
    String fnameinput,lnameinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        spingender = findViewById(R.id.sex);
        spinuniversity = findViewById(R.id.university);
        spinschool = findViewById(R.id.school);
        dateofbirth = findViewById(R.id.dateofbirth);
        spinsemester = findViewById(R.id.semester);
        termscondition = findViewById(R.id.termscondition);
        signupbtn = findViewById(R.id.signupbt);
        emailadd = findViewById(R.id.emailaddress);
        emailinvali = findViewById(R.id.emailtext);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        passwd = findViewById(R.id.password);
        passwordcnf = findViewById(R.id.confirmpassword);
        passwdinvalid = findViewById(R.id.passwdinvalid);
        passwdcnfinvalid = findViewById(R.id.passwdcnfinvald);
        fnamerq=findViewById(R.id.fnamerq);
        lnamerq=findViewById(R.id.lnamerq);
        sexrq=findViewById(R.id.sexrq);
        dorq=findViewById(R.id.dorq);
        unirq=findViewById(R.id.unirq);
        schrq=findViewById(R.id.schrq);
        csrq=findViewById(R.id.csrq);



        //terms and condition checked
        boolean ischecked = termscondition.isChecked();


        /////calender instance
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //calender setonclickmethod
        dateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(signup.this, new DatePickerDialog.OnDateSetListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        dateofbirth.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                        dateob=SimpleDateFormat.getDateInstance().format(calendar.getTime());


                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });
        //////// date of birth ends here


        //sex_drop_dwonmenu array adapter
        ArrayAdapter<CharSequence> genderadapter = ArrayAdapter.createFromResource(this, R.array.sex, R.layout.dropdown);
        genderadapter.setDropDownViewResource(R.layout.dropdown);
        spingender.setAdapter(genderadapter);
        spingender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //gender drop ends here

        ///////////////////////////////////////////////////////////////////////////////////////////

        ///university dropdown arraydapter

        ArrayAdapter<CharSequence> universityadapter = ArrayAdapter.createFromResource(this, R.array.university, R.layout.dropdown);
        universityadapter.setDropDownViewResource(R.layout.dropdown);
        spinuniversity.setAdapter(universityadapter);
        spinuniversity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                university = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        //university dropdwon ends here

        //////////////////////////////////////////////////////


        //school dropdown arrayadapter

        ArrayAdapter<CharSequence> schooladapter = ArrayAdapter.createFromResource(this, R.array.school, R.layout.dropdown);
        schooladapter.setDropDownViewResource(R.layout.dropdown);
        spinschool.setAdapter(schooladapter);
        spinschool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                school = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ///school dropdown ends here


        ////current semester dropdown Arraydapter
        ArrayAdapter<CharSequence> semesteradapter = ArrayAdapter.createFromResource(this, R.array.semester, R.layout.dropdown);
        semesteradapter.setDropDownViewResource(R.layout.dropdown);
        spinsemester.setAdapter(semesteradapter);
        spinsemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ///current semester ends here

        //////sinup button
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             boolean emailval=   emailvalidation(emailadd);
                passwordvalidation(passwd, passwordcnf);
                fnamevalidatio(firstname);
                lnamevalidatio(lastname);
                gendervalidation();
                dobvalidation(dateofbirth);
                universityvalidatio();
                schoolvalidatio();
                currentsemvalidatio();


            }
        });


    }

    ///email validation
    boolean emailvalidation(EditText emailadd) {

        emailinput = emailadd.getText().toString();
        if (!emailinput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
            emailinvali.setText(" ");
            return true;
        } else {
            emailinvali.setText("Invalid E-mail");

            return false;
        }

    }
////ends here


    //password validation
    void passwordvalidation(EditText passwd, EditText passwordcnf) {

        passwdinput = passwd.getText().toString();
        passwdcnfinput = passwordcnf.getText().toString();
        int passwdlen, passwdcnflen;

        passwdlen = passwdinput.length();
        passwdcnflen = passwdcnfinput.length();


        if (!passwdinput.isEmpty() && !passwdcnfinput.isEmpty()) {

            if (passwdlen >= 8) {


                if (passwdinput.equals(passwdcnfinput)) {
                    passwdinvalid.setText(" ");
                    passwdcnfinvalid.setText(" ");
                    pss=pss+1;
                }
                else{


                    passwdcnfinvalid.setText("password didn't match");

                }
            } else {
                passwdinvalid.setText("Weak password");

            }

        } else {
            passwdinvalid.setText("Enter password");
            passwdcnfinvalid.setText("Enter password");

        }


    }

    //end here

//firstname validation
    boolean fnamevalidatio(EditText firstname) {
        fnameinput = firstname.getText().toString();

        if (!fnameinput.isEmpty()) {
            fnamerq.setText(" ");
            return true;
        } else {

            fnamerq.setText("*Required");
            return  false;



        }
    }
    //ends here

    //lirstname validation
    boolean lnamevalidatio(EditText lastname) {
        lnameinput = lastname.getText().toString();

        if (!lnameinput.isEmpty()) {
            lnamerq.setText(" ");
            return true;
        } else {

            lnamerq.setText("*Required");
            return  false;



        }
    }
    //ends here

//gender validation
    boolean gendervalidation() {
        String genderinput=gender;
        String gs="sex";


        if (genderinput.equals(gs)) {
            sexrq.setText("*Required");
            return false;
        } else {

            sexrq.setText(" ");
            return  true;



        }
    }
    //endshere

    //dob validation
    boolean dobvalidation(EditText dateofbirth) {
        String dobinput=dateofbirth.getText().toString();
        if (dobinput.isEmpty()) {
            dorq.setText("*Required");
            return false;
        } else {

            dorq.setText(" ");
            return  true;



        }
    }
    //ends here

    //university validation
    boolean universityvalidatio() {
        String  uniinput=university;
        String us="University";

        if (uniinput.equals(us)) {
            unirq.setText("*Required");
            return false;
        } else {

            unirq.setText(" ");
            return  true;



        }
    }
    //ends here


    //school validation
    boolean schoolvalidatio() {
        String  schinput=school;
        String schs="School";

        if (schinput.equals(schs)) {
            schrq.setText("*Required");
            return false;
        } else {

            schrq.setText(" ");
            return  true;



        }
    }
    //ends here


    //current sem validation
    boolean currentsemvalidatio() {
        String  cseminput=semester;
        String scsems="Current Semester";

        if (cseminput.equals(scsems)) {
            csrq.setText("*Required");
            return false;
        } else {

            csrq.setText(" ");
            return  true;



        }
    }
    //ends here













}
