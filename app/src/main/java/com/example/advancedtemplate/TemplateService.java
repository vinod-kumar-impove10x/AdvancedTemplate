package com.example.advancedtemplate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TemplateService {
     @GET("templates")
     Call<List<Template>> fetchTasks();

     @POST("templates")
     Call<Template> createTasks(@Body Template template);
}
