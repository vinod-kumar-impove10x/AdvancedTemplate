package com.example.advancedtemplate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TemplateAdapter extends RecyclerView.Adapter<TemplateViewHolder> {

    public ArrayList<Template> templates;

    public void setData(ArrayList<Template> templateList) {templates = templateList;}

    @NonNull
    @Override
    public TemplateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_item,parent,false);
        TemplateViewHolder templateViewAdapter = new TemplateViewHolder(view);
        return templateViewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateViewHolder holder, int position) {
        Template template = templates.get(position);
        holder.messageText.setText(template.message);

    }

    @Override
    public int getItemCount() {
        return templates.size();
    }
}
