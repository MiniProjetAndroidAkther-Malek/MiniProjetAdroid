package com.example.miniprojectakthemmalek.model.api.entityInterface;

import com.example.miniprojectakthemmalek.model.entities.Post;
import com.example.miniprojectakthemmalek.model.entities.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IPost {

@POST("posts/add")
Call<JsonPrimitive> addPost(@Body Post post);

@GET("/posts/getAll")
Call<List<Post>> getAllPosts();

@GET("/posts/getAllByGroupName/{group_name}")
Call<List<Post>> getAllPostsByGroupName(@Path("group_name") String group_name);

@GET("/posts/getAll/{username}")
Call<List<Post>> getAllPostsOf(@Path("username") String username);


@GET("/posts/getById/{id}")
Call<List<Post>> getAllPostsById(@Path("id") String id);

@GET("/post/get/{username}/{description}")
Call<List<Post>> getPost(@Path("username") String username,@Path("description") String description);

@DELETE("/posts/delete/{id}")
Call<JsonObject> deletePost(@Path("id") String id);

@PUT("/posts/updateDescription")
Call<JsonObject> updateDescription(@Body Post post);



@POST("/post/getLastId")
Call<String> getLastInsertedId();

}
