package com.example.week2day4homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvname;
    Button btnGoToResultActivity;
    public static final int REQUEST_CODE = 225;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        sharedPreferences = getSharedPreferences("name",MODE_PRIVATE);
    }


    public void bindViews() {
        tvname = findViewById(R.id.tvname);
        btnGoToResultActivity = findViewById(R.id.btnStartActivityforResult);


    }




    public void onClickforResult(View view) {
        Intent intent = new Intent(this,ResultActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String name = data.getStringExtra("name");
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        sharedPrefEditor.putString("name", name);
        sharedPrefEditor.commit();
        tvname.setText(name);

    }





}
