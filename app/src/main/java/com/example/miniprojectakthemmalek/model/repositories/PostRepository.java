package com.example.miniprojectakthemmalek.model.repositories;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.miniprojectakthemmalek.model.api.RetrofitInstance;
import com.example.miniprojectakthemmalek.model.api.entityInterface.IPost;
import com.example.miniprojectakthemmalek.model.api.entityInterface.IUser;
import com.example.miniprojectakthemmalek.model.entities.Post;
import com.example.miniprojectakthemmalek.model.entities.User;
import com.example.miniprojectakthemmalek.view.adapter.PostAdapter;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private static PostRepository instance;


    public static PostRepository getInstance(){
        if(instance == null){
            instance = new PostRepository();
        }
        return instance;
    }

    IPost iPost = RetrofitInstance.getRetrofitInstance().create(IPost.class);

    public void addPost(Post post, final getLastInsertedCallBack callback )
    {
        Call<JsonPrimitive> call ;

        call =  iPost.addPost(post);
        call.enqueue(new Callback<JsonPrimitive>() {
            @Override
            public void onResponse(Call<JsonPrimitive> call, Response<JsonPrimitive> response) {

                callback.onResponse(response.body());

            }

            @Override
            public void onFailure(Call<JsonPrimitive> call, Throwable t) {

                t.printStackTrace();

            }
        });

    }


    public void deleteUser(String  id,final addingCallback addingCallback)
    {
        Call<JsonObject> call = iPost.deletePost(id);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                addingCallback.addingCallback(response.code());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                t.printStackTrace();
                addingCallback.addingCallback(0);

            }
        });

    }

    public void getAllPostByGroupName(String group_name,final getAllPostCallBack allPostCallBack)
{
    Call<List<Post>> call;
    call = iPost.getAllPostsByGroupName(group_name);
    call.enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

            allPostCallBack.onResponse(response.body());
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {

            t.printStackTrace();
        }
    });

}


public void getPostById(String id,final getAllPostCallBack allPostCallBack)
    {
        Call<List<Post>> call;
        call = iPost.getAllPostsById(id);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                allPostCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                t.printStackTrace();
            }
        });

    }

    public void getPost(String username , String description,final getAllPostCallBack allPostCallBack)
    {
        Call<List<Post>> call;
        call = iPost.getPost(username,description);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                allPostCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                t.printStackTrace();
            }
        });

    }


    public void getAllPost(final getAllPostCallBack allPostCallBack)
    {
        Call<List<Post>> call;
        call = iPost.getAllPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

         allPostCallBack.onResponse(response.body());

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                t.printStackTrace();
            }

        });
    }

    public void getAllPostOf(String username,final getAllPostCallBack allPostCallBack)
    {
        Call<List<Post>> call;
        call = iPost.getAllPostsOf(username);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                allPostCallBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                t.printStackTrace();
            }
        });

    }

    public void updateDescriptionPost(Post post,final addingCallback addingCallback)
    {
        Call<JsonObject> call ;
        call = iPost.updateDescription(post);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                addingCallback.addingCallback(response.code());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                t.printStackTrace();

            }
        });

    }




public interface getAllPostCallBack
{
    public void onResponse(List<Post> posts);
}

public interface getLastInsertedCallBack
{
    public void onResponse(JsonPrimitive id);
}

    public interface addingCallback
    {
        public void addingCallback(int code);
    }

    public interface addingPostCallback
    {
        public void addingCallback(Post post);
    }
}
