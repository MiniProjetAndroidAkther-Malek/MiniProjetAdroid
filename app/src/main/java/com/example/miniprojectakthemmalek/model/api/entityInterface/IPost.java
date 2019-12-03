package com.example.miniprojectakthemmalek.model.api.entityInterface;

import com.example.miniprojectakthemmalek.model.entities.Post;
import com.example.miniprojectakthemmalek.model.entities.User;
import com.google.gson.JsonPrimitive;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IPost {


@POST("posts/add")
Call<JsonPrimitive> addPost(@Body Post post);

@GET("/posts/getAll")
Call<List<Post>> getAllPosts();

}