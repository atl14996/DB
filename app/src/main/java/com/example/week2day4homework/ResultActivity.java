package com.example.week2day4homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    EditText etname;
    EditText etaddress;
    EditText etcity;
    EditText etstate;
    EditText etzip;
    EditText etemail;
    EditText etphone;
    SharedPreferences sharedPreferences;
    Intent passedIntent;
    public static int userid = 1;
    UserDatabaseHelper userDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
        bindViews();
        passedIntent = getIntent();
    }


    public void bindViews() {

        etname = findViewById(R.id.etname);
        etaddress = findViewById(R.id.etaddress);
        etcity = findViewById(R.id.etcity);
        etstate = findViewById(R.id.etstate);
        etzip = findViewById(R.id.etzip);
        etemail = findViewById(R.id.etemail);
        etphone = findViewById(R.id.etphone);
    }

    public void onClick(View view) {

        String spname = etname.getText().toString();
        passedIntent.putExtra("name", spname);
        setResult(125, passedIntent);
        String username = etname.getText().toString();
        String address = etaddress.getText().toString();
        String city = etcity.getText().toString();
        String state = etstate.getText().toString();
        String zip = etzip.getText().toString();
        String phone = etphone.getText().toString();
        String email = etemail.getText().toString();
        userid += 1;
        User user = new User(username, address, city, state, zip, phone,email, userid);
userDatabaseHelper.insertUserIntoDatabase(user);
        ArrayList<User> userList = userDatabaseHelper.getAllUsersFromDatabase();
        for(User currentUser : userList)  {
            Log.d("TAG", currentUser.toString());
            finish();

    }}}









