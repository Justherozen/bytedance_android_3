package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Enter_ex1(View view) {
        Intent intent = new Intent(this, ex1.class);
        startActivity(intent);
    }
    public void Enter_ex2(View view) {
        Intent intent = new Intent(this, ex2.class);
        startActivity(intent);
    }
}
