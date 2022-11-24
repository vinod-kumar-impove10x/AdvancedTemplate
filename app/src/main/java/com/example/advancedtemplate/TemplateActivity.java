package com.example.advancedtemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import javax.xml.transform.Templates;

public class TemplateActivity extends AppCompatActivity {

    public ArrayList<Template> templates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        getSupportActionBar().setTitle("Template");
        setupDta();

    }

    private void setupDta() {
        templates = new ArrayList<>();

        Template message1 = new Template();
        message1.message = "Hello improve 10X";
        templates.add(message1);

        Template message2 = new Template();
        message2.message = " All is well";
        templates.add(message2);
    }
}