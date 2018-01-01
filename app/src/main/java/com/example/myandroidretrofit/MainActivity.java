package com.example.myandroidretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPosts = findViewById(R.id.lv_main_posts);

        getPosts();

    }

    private void getPosts() {

        // Create a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create the postApi interface
        PostApi postApi = retrofit.create(PostApi.class);

        // Make the call object
        Call call = postApi.getPosts();

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                if (response.isSuccessful()) {

                    List<Post> postList= (List<Post>) response.body();

                    // Create a string array for the ListView
                    String[] posts = new String[postList.size()];

                    // Loop through all the posts
                    for (int i=0; i<postList.size(); i++) {
                        posts[i] = postList.get(i).getTitle();
                    }

                    // Display the string array into ListView
                    lvPosts.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, posts));

                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });


    }
}
