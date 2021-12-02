package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);

        Intent intent = getIntent();
        String search = "SEARCH";
        if (intent.hasExtra("search")) {
            search = intent.getStringExtra("search");
            toastAfficheMessage(search);

            GithubService githubService = new Retrofit.Builder()
                    .baseUrl(GithubService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GithubService.class);

            githubService.searchRepos(search).enqueue(new Callback<ReposResponse>() {
                @Override
                public void onResponse(Call<ReposResponse> call, Response<ReposResponse> response) {
                    //toastAfficheMessage("Data ok");
                    afficherRepo(response.body());
                }
                @Override
                public void onFailure(Call<ReposResponse> call, Throwable t) {
                    toastAfficheMessage("Erreur");
                }
            });

        }

    }

    public void toastAfficheMessage(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void afficherRepo(ReposResponse reposRes){
        if(reposRes != null){
            RecyclerView rvRepos = (RecyclerView) findViewById(R.id.rvRepos);

            RepoAdapter adapter = new RepoAdapter(reposRes.getItems());
            rvRepos.setAdapter(adapter);
            rvRepos.setLayoutManager(new LinearLayoutManager(this));
        }
    }

}