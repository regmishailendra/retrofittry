package com.my.retrofit;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment {

    String topTextString,bottomTextString;
    TopSectionListener topSectionListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    topSectionListener= (TopSectionListener) context;  //imp


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View v= inflater.inflate(R.layout.fragment_top,container,false);
        final EditText topText,bottomText;
        Button createMeme;
topText=v.findViewById(R.id.toptext);
bottomText=v.findViewById(R.id.bottomtext);
createMeme=v.findViewById(R.id.creatememe);









createMeme.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                topTextString=topText.getText().toString();
                bottomTextString=bottomText.getText().toString();

                topSectionListener.createMeme(topTextString,bottomTextString);     //imp

                Log.v("checkcheck","create meme fragment one");

            }
        }
);
return v;










    }









}
