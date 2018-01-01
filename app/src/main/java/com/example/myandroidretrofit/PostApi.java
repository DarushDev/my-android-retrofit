package com.example.myandroidretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Darush on 1/1/2018.
 */

public interface PostApi {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> getPosts();

}
