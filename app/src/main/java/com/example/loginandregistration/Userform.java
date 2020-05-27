package com.example.loginandregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Userform extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button _btnReg;
    EditText _txtName, _txtMName, _txtLName,_txtCaste,
            _txtOther,_txtDob,_txtQualification,_txtPhone,_txtExpect,_txtHeight,
            _txtAdd, _txtEmail, _txtUser, _txtPass;
    Spinner _spinnerSubCaste,_txtMarStatus;
    private TextView mDisplayDate;
    private static final String TAG = "Userform";
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userform);
        _btnReg=(Button)findViewById(R.id.btnReg);
        _txtName=(EditText)findViewById(R.id.txtName);
        _txtMName=(EditText)findViewById(R.id.txtMName);
        _txtLName=(EditText)findViewById(R.id.txtLName);
        final RadioGroup _radioG=(RadioGroup)findViewById(R.id.radioG);
        _txtCaste=(EditText)findViewById(R.id.txtCaste);
        _spinnerSubCaste=(Spinner) findViewById(R.id.spinnerSubCaste);
        _txtOther=(EditText)findViewById(R.id.txtOther);
//        _txtDob=(EditText)findViewById(R.id.txtDob);
        _txtMarStatus=(Spinner)findViewById(R.id.txtMarStatus);
        _txtQualification=(EditText)findViewById(R.id.txtQualification);
        _txtPhone=(EditText)findViewById(R.id.txtPhone);
        _txtExpect=(EditText)findViewById(R.id.txtExpect);
        _txtHeight=(EditText)findViewById(R.id.txtHeight);
        _txtEmail=(EditText)findViewById(R.id.txtEmail);
        _txtUser=(EditText)findViewById(R.id.txtUser);
        _txtPass=(EditText)findViewById(R.id.txtPass);
        _txtAdd=(EditText) findViewById(R.id.txtAdd);
        mDisplayDate = (TextView) findViewById(R.id.txtDob);

        _txtMarStatus.setOnItemSelectedListener(this);
        List<String> MStatus = new ArrayList<String>();
        MStatus.add("Select");
        MStatus.add("Single");
        MStatus.add("Widowed");
        MStatus.add("Divorced");
        MStatus.add("Separated");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapters1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MStatus);
        // Drop down layout style - list view with radio button
        dataAdapters1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        _txtMarStatus.setAdapter(dataAdapters1);


        //Spinner spinSubCaste = (Spinner) findViewById(R.id.spinnerSubCaste);
        // Spinner click listener
        _spinnerSubCaste.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> subcategories = new ArrayList<String>();
        subcategories.add("Select Subcaste");
        subcategories.add("zcz");
        subcategories.add("fg");
        subcategories.add("गुंडली");
        subcategories.add("गुलायन");
        subcategories.add("कुडावला");
        subcategories.add("कल्यान");
        subcategories.add("कान्हेरे");
        subcategories.add("कारले");
        subcategories.add("तालन");
        subcategories.add("चादावत");
        subcategories.add("तोरले");
        subcategories.add("ब्यावात");
        subcategories.add("डाल्डरे");
        subcategories.add("साल्डरे");
        subcategories.add("खेडरे");
        subcategories.add("नौथा");
        subcategories.add("नाल्डरे");
        subcategories.add("न्यावत");
        subcategories.add("हांसू");
        subcategories.add("हडगल");
        subcategories.add("हरावत");
        subcategories.add("मालावत");
        subcategories.add("बावरु");
        subcategories.add("सोलंकी");
        subcategories.add("भोगर");
        subcategories.add("इत्यादी");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapters = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subcategories);
        // Drop down layout style - list view with radio button
        dataAdapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        _spinnerSubCaste.setAdapter(dataAdapters);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        Userform.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };


        setTitle("New User Registration");
        _btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=_txtName.getText().toString().trim();
                String MName=_txtMName.getText().toString().trim();
                String LName=_txtLName.getText().toString().trim();
                int Gen=_radioG.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(Gen);
                String gender = selectedRadioButton.getText().toString();
                String Caste= _txtCaste.getText().toString();
                String SubCaste= (String) _spinnerSubCaste.getSelectedItem();
                String OtherCaste=_txtOther.getText().toString();
                String Dob=mDisplayDate.getText().toString();
                String MarStatus= (String) _txtMarStatus.getSelectedItem();
                //String MarStatus=_txtMarStatus.getText().toString();
                String Qualification=_txtQualification.getText().toString();
                String Phone=_txtPhone.getText().toString();
                String Expectation=_txtExpect.getText().toString();
                String Height=_txtHeight.getText().toString();
                String address=_txtAdd.getText().toString();
                String email=_txtEmail.getText().toString();
                String username=_txtUser.getText().toString();
                String password=_txtPass.getText().toString();
                String type="reg";

                if (name.matches("") || address.matches("") || email.matches("") ||
                        username.matches("") || password.matches("")) {
                    Toast.makeText(Userform.this, "Do not keep Fileds Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                BackgroundTask backgroundTask= new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type, name, MName,LName, address,gender,Caste,SubCaste,OtherCaste
                        ,Dob,MarStatus,Qualification,Phone,Expectation,Height,email, username, password);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
