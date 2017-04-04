package com.news.channy.retrofitvsvolley;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sokchanny on 4/3/17.
 */

public interface NewsRepository {
    @GET("/articles?source=bbc-sport&sortBy=top&apiKey=8eb03efc49924bf88b73e8af59fd6bf6")
    Call<List<GitHubRepos>> reposForUser();
}
