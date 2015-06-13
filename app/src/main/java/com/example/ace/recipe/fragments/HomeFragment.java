package com.example.ace.recipe.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ace.recipe.R;

/**
 * Created by Martin on 10-Mar-15.
 */
public class HomeFragment extends Fragment {

    LinearLayout dinner;
    LinearLayout dessert;
    LinearLayout enter;
    LinearLayout healthy;

    int[] dinnerPics={R.drawable.dinner1,R.drawable.dinner2,R.drawable.dinner3};
    int[] dessertPics={R.drawable.dessert1,R.drawable.dessert2,R.drawable.dessert3};
    int[] enterPics={R.drawable.enter1,R.drawable.enter2,R.drawable.enter3};
    int[] healthyPics={R.drawable.healthy1,R.drawable.healthy2,R.drawable.healthy3};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_fragment, container, false);

        dinner=(LinearLayout) v.findViewById(R.id.myGallery);
        dessert=(LinearLayout) v.findViewById(R.id.myGallery2);
        enter=(LinearLayout) v.findViewById(R.id.myGallery3);
        healthy=(LinearLayout) v.findViewById(R.id.myGallery4);

        for (int i = 0; i < 3; i++) {
            ImageView picture=new ImageView(getActivity().getBaseContext());
            picture.setAdjustViewBounds(true);
            picture.setImageResource(dinnerPics[i]);
            picture.setPadding(5,5,5,5);
            dinner.addView(picture);

            ImageView picture2=new ImageView(getActivity().getBaseContext());
            picture2.setAdjustViewBounds(true);
            picture2.setImageResource(dessertPics[i]);
            picture2.setPadding(5,5,5,5);
            dessert.addView(picture2);

            ImageView picture3=new ImageView(getActivity().getBaseContext());
            picture3.setAdjustViewBounds(true);
            picture3.setImageResource(enterPics[i]);
            picture3.setPadding(5,5,5,5);
            enter.addView(picture3);

            ImageView picture4=new ImageView(getActivity().getBaseContext());
            picture4.setAdjustViewBounds(true);
            picture4.setImageResource(healthyPics[i]);
            picture4.setPadding(5,5,5,5);
            healthy.addView(picture4);
        }

        return v;
    }

}
