package com.my.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadClient {


    @Multipart
    @POST("api/v1/bill-upload")
    Call<ResponseBody> uploadPhoto(@Part("full_name") RequestBody full_name,
                                  @Part("mobile") RequestBody mobile,
                                  @Part("email") RequestBody email,
                                  @Part MultipartBody.Part file


    );


}
