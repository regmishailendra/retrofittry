package com.my.retrofit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements TopSectionListener {
    ListView listview;
    private ArrayList<String> filePaths;
    private ArrayList<String> photoPaths;
    private ArrayList<String> docPaths;

    Button select;
    Button upload;
String finalPhotoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        listview = findViewById(R.id.listview);
//
//        //get request git hub
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//        //first build retrofit     -> BUILD
//        final Retrofit retrofit = builder.build();
//
//
//        // the create retrofit object      -> CREATE
//        GithubClient client = retrofit.create(GithubClient.class);
//
//
//        // then make a call object to utilize it -> CALL
//        Call<List<GithubRepo>> call = client.repoList("regmishailendra");
//
//
//        //we have two options here
//
//        call.enqueue(new Callback<List<GithubRepo>>() {
//            @Override
//            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
//
//                List<GithubRepo> repos = response.body();
//
//                List<String> reposString = new ArrayList<>();
//
//                for (GithubRepo repo : repos) {
//
//                    reposString.add(repo.getName());
//
//                }
//
//
//                listview.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, reposString));
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Something went wrong. Sorry!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//// post request booking
//        BookObject bookObject = new BookObject();
//        bookObject.setFull_name("Shailendra");
//        bookObject.setAddress("Buddhanagar");
//        bookObject.setEmail("regmishailendra@gmail.com");
//        bookObject.setMobile("123456789");
//        bookObject.setProduct_id(2);
//
//
////build create call enque
//
//
//        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
//        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        okHttpClientBuilder.addInterceptor(interceptor);
//
//
//
//
//
//
//
//        Retrofit.Builder bookBuilder = new Retrofit.Builder()
//                .baseUrl("http://nepalgas.bidheellc.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClientBuilder.build());
//
//
//        Retrofit retrofitOfBook = bookBuilder.build();
//
//
//        BookClient bookClient = retrofitOfBook.create(BookClient.class);
//        Call<SuccessObject> callBook = bookClient.bookCylinder(bookObject);
//        listview.setVisibility(View.GONE);
//
//        final TextView textview = findViewById(R.id.textview);
//
//
//        callBook.enqueue(new Callback<SuccessObject>() {
//            @Override
//            public void onResponse(Call<SuccessObject> call, Response<SuccessObject> response) {
//                String responseText = response.body().getMessage() + " - " + response.body().error + " - " + response.body().getStatus_code();
//
//
//             //   textview.setText(responseText);
//
//            }
//
//            @Override
//            public void onFailure(Call<SuccessObject> call, Throwable t) {
//
//            }
//        });
//
//
//
//        select=findViewById(R.id.select);
//        upload=findViewById(R.id.upload);
//
//
//        select.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        FilePickerBuilder.getInstance().setMaxCount(5)
//                                .setSelectedFiles(filePaths)
//                                .setActivityTheme(R.style.AppTheme)
//                                .pickPhoto(MainActivity.this);
//
//
//                    }
//                }
//        );
//
//upload.setOnClickListener(
//        new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////make a request body for all the strings
//Log.v("checkpath",finalPhotoPath+"");
//
//                File originalFile=new File(finalPhotoPath);
//                Uri fileUri = null;
//                try {
//                    fileUri = Uri.parse(
//                            android.provider.MediaStore.Images.Media.insertImage(
//                                    getContentResolver(),
//                                    originalFile.getAbsolutePath(), null, null));
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//
//
//                Log.v("checkpath",fileUri.toString()+" is the file uri");
//
//
//
//
//                RequestBody fullNameRequestBody = RequestBody.create(MultipartBody.FORM,"This is the full name");
//                RequestBody mobileRequestBody = RequestBody.create(MultipartBody.FORM,"12123232");
//                RequestBody emailRequestBody = RequestBody.create(MultipartBody.FORM,"email@gmail.com");
//
//// now make a multipart body for file. This is the two step process.
//
//                RequestBody filePart = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)),originalFile);
//                MultipartBody.Part file= MultipartBody.Part.createFormData("file",originalFile.getName(),filePart);
//
//
//
//  Retrofit.Builder fileBuilder= new Retrofit.Builder()
//          .baseUrl("http://nepalgas.bidheellc.com/")
//          .addConverterFactory(GsonConverterFactory.create());
//
//  Retrofit fileRetrofit =  fileBuilder.build();
//
//  UploadClient uploadClient=fileRetrofit.create(UploadClient.class);
//
//  Call<ResponseBody> fileCall = uploadClient.uploadPhoto(fullNameRequestBody,mobileRequestBody,emailRequestBody,file);
//
//fileCall.enqueue(new Callback<ResponseBody>() {
//    @Override
//    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//        Toast.makeText(MainActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onFailure(Call<ResponseBody> call, Throwable t) {
//        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//
//    }
//}); }});
//















    }

    @Override
    public void createMeme(String topText, String bottomText) {
Log.v("checkcheck","main create meme");
        FragmentTwo fragmentTwo= (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragmentTwo.setMeme(topText,bottomText);




    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode)
//        {
//            case FilePickerConst.REQUEST_CODE_PHOTO:
//                if(resultCode== Activity.RESULT_OK && data!=null)
//                {
//                    photoPaths = new ArrayList<>();
//                    photoPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
//
//
//                    for (String photo :photoPaths ) {
//
//                      finalPhotoPath=photo;
//
//
//
//                    }
//
//                }
//                break;
//            case FilePickerConst.REQUEST_CODE_DOC:
//                if(resultCode== Activity.RESULT_OK && data!=null)
//                {
//                    docPaths = new ArrayList<>();
//                    docPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_DOCS));
//                }
//                break;
//        }
//
//    }








}
