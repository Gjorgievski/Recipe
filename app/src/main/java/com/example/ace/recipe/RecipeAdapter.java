package com.example.ace.recipe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ace on 3/11/2015.
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{


    private List<RecipeInfo> recipeList;
    private ViewGroup viewGroup;

    public RecipeAdapter(List<RecipeInfo> contactList) {
        this.recipeList = contactList;
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder recipeViewHolder, int i) {
        RecipeInfo ri = recipeList.get(i);

        Picasso.with(viewGroup.getContext()).load(ri.getImageUrl()).into(recipeViewHolder.vImage);
        recipeViewHolder.vTitle.setText(ri.getTitle());
        recipeViewHolder.vDescription.setText(ri.getDescription());
        recipeViewHolder.vRating.setRating((float)ri.getRating());
        recipeViewHolder.vFavourite.setChecked(ri.isFavourite()?true:false);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view, viewGroup, false);

        this.viewGroup=viewGroup;

        return new RecipeViewHolder(itemView);
        
    }




    public static class RecipeViewHolder extends RecyclerView.ViewHolder {

        protected ImageView vImage;
        protected TextView vTitle;
        protected TextView vDescription;
        protected RatingBar vRating;
        protected ToggleButton vFavourite;

        public RecipeViewHolder(View v) {
            super(v);
            vImage = (ImageView) v.findViewById(R.id.image);
            vTitle = (TextView) v.findViewById(R.id.title);
            vDescription = (TextView) v.findViewById(R.id.description);
            vRating = (RatingBar) v.findViewById(R.id.rating);
            vFavourite = (ToggleButton) v.findViewById(R.id.tbtnFavourite);
        }
    }
}
