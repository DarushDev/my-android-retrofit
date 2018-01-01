package com.example.myandroidretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Darush on 1/1/2018.
 */

public class Post {

    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
