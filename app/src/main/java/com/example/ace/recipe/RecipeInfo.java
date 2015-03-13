package com.example.ace.recipe;

/**
 * Created by Ace on 3/11/2015.
 */
public class RecipeInfo {

    private String title;
    private String description;
    private String imageUrl;
    private double rating;
    private boolean favourite;


    public RecipeInfo(){    
    }

    public RecipeInfo(String title, String description, String imageUrl, double rating, boolean favourite) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.favourite=favourite;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFavourite() { return favourite; }

    public void setFavourite(boolean favourite) { this.favourite = favourite; }
}


//ace