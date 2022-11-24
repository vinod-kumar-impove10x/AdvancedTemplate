package com.example.advancedtemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

import javax.xml.transform.Templates;

public class TemplateActivity extends AppCompatActivity {

    public ArrayList<Template> templates;
    public RecyclerView templateRv;
    public TemplateAdapter templateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        getSupportActionBar().setTitle("Template");
        handleAddButton();
        setupDta();
        setupTemplates();

    }

    private void handleAddButton() {
            Button addBtn = findViewById(R.id.button_btn);
            addBtn.setOnClickListener(view -> {
                Intent intent = new Intent(this, AddTemplateActivity.class);
                startActivity(intent);
            });
    }

    private void setupTemplates() {
        templateRv = findViewById(R.id.template_rv);
        templateRv.setLayoutManager(new LinearLayoutManager(this));
        templateAdapter = new TemplateAdapter();
        templateAdapter.setData(templates);
        templateRv.setAdapter(templateAdapter);
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