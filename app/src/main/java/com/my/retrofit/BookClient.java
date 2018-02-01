package com.my.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BookClient {
    @POST("api/v1/booking")
    Call<SuccessObject> bookCylinder(@Body BookObject bookObject);
}
