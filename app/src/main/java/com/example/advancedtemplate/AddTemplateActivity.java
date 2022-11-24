package com.example.advancedtemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_template);
        getSupportActionBar().setTitle("Add Template");
        Button addMessageBtn = findViewById(R.id.add_btn);
        addMessageBtn.setOnClickListener(view -> {
            EditText messageTxt = findViewById(R.id.add_message_txt);
            String message = messageTxt.getText().toString();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        });
    }
}