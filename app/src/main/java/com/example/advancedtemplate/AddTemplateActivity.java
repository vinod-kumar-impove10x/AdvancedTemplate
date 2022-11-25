package com.example.advancedtemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.xml.transform.Templates;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            createTemplate(message);
        });
    }

    private void createTemplate(String message) {

        Template template = new Template();
        template.message = message;

        TemplateApi templateApi = new TemplateApi();
        TemplateService service = templateApi.createTemplateService();
        Call<Template> call = service.createTasks(template);
        call.enqueue(new Callback<Template>() {
            @Override
            public void onResponse(Call<Template> call, Response<Template> response) {
                Toast.makeText(AddTemplateActivity.this, "Successfully added task", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Template> call, Throwable t) {
                Toast.makeText(AddTemplateActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}