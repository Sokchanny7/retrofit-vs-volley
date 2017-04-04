package com.news.channy.retrofitvsvolley;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by sokchanny on 4/3/17.
 */

public interface GitHubClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepos>> reposForUser(
            @Path("user") String user
    );
}