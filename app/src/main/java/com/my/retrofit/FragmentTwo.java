package com.my.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    TextView toptext;
    TextView bottomtext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

View v= inflater.inflate(R.layout.fragment_bottom,container,false);

         toptext=v.findViewById(R.id.toptextview);
         bottomtext=v.findViewById(R.id.bottomtextview);
return v;

    }



    public void setMeme(String topText,String bottomText){
        Log.v("checkcheck","set meme fragment  two");
        toptext.setText(topText);
        bottomtext.setText(bottomText);


    }


}
