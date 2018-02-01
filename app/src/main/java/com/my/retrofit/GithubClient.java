package com.my.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubClient {



    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> repoList(@Path("user") String username);





}
