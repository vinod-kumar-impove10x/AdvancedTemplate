package com.example.advancedtemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        TemplateApi templateApi = new TemplateApi();
        TemplateService templateService = templateApi.createTemplateService();
        Call<List<Template>> call = templateService.fetchTasks();
        call.enqueue(new Callback<List<Template>>() {
            @Override
            public void onResponse(Call<List<Template>> call, Response<List<Template>> response) {
                List<Template> templates = response.body();
                templateAdapter.setData(templates);
            }

            @Override
            public void onFailure(Call<List<Template>> call, Throwable t) {
                Toast.makeText(TemplateActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleAddButton() {
            Button addBtn = findViewById(R.id.button_btn);
            addBtn.setOnClickListener(view -> {
                Intent intent = new Intent(this, AddTemplateActivity.class);
                startActivity(intent);
            });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        fetchData();
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