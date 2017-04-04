package com.news.channy.retrofitvsvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String url = " https://newsapi.org/v1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRetrofit   = (Button)      findViewById(R.id.buttonRetrofit);
        Button buttonVolley     = (Button)      findViewById(R.id.buttonVolley);
        final TextView textViewResult = (TextView)    findViewById(R.id.textViewResult);


        buttonRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String API_BASE_URL = "https://api.github.com/";

                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

                Retrofit.Builder builder =
                        new Retrofit.Builder()
                                .baseUrl(API_BASE_URL)
                                .addConverterFactory(
                                        GsonConverterFactory.create()
                                );

                Retrofit retrofit =
                        builder
                                .client(httpClient.build())
                                .build();

                GitHubClient client =  retrofit.create(GitHubClient.class);
                Call<List<GitHubRepos>> call = client.reposForUser("sokchanny7");

                call.enqueue(new Callback<List<GitHubRepos>>() {
                    @Override
                    public void onResponse(Call<List<GitHubRepos>> call, Response<List<GitHubRepos>> response) {
                        List<GitHubRepos> repos = response.body();
                        String str = "";
                        for(GitHubRepos repo : repos) {
                            str += repo.getName();
                        }
                        textViewResult.setText(str);
                    }

                    @Override
                    public void onFailure(Call<List<GitHubRepos>> call, Throwable t) {
                        textViewResult.setText("Erro :(");
                    }
                });

            }
        });

        buttonVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
