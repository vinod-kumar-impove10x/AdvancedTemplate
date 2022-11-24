package com.example.advancedtemplate;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TemplateViewHolder extends RecyclerView.ViewHolder {

    public TextView messageText;

    public TemplateViewHolder(@NonNull View itemView) {
        super(itemView);

        messageText = itemView.findViewById(R.id.message_txt);
    }
}
