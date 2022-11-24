package com.example.advancedtemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        getSupportActionBar().setTitle("Template");
    }
}