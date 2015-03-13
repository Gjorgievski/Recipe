package com.example.ace.recipe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ace on 3/11/2015.
 */
public class CategoryFragment extends Fragment {

    private String category;

    public CategoryFragment() {
    }

    //set arguments

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_category, container, false);


        RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.cardList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        String category = getArguments().getString("category");
        RecipeAdapter ra=null;

        switch(category){
            case "dinner":{
                ra = new RecipeAdapter(getDinner());
                break;
            }
            case "dessert":{
                ra = new RecipeAdapter(getDessert());
                break;
            }
            case "entertaining":{
                ra = new RecipeAdapter(getEntertaining());
                break;
            }
            case "healty":{
                ra = new RecipeAdapter(getHealty());
                break;
            }
            default:{
                break;
            }
        }

        //RecipeAdapter ra = new RecipeAdapter(getDinner());
        recList.setAdapter(ra);

        return rootView;
    }


    private List<RecipeInfo> getDinner(){

        RecipeInfo r1 = new RecipeInfo("Chicken Rotini Stovetop Casserole",
                "Rotini pasta tossed with chicken, bell pepper and a creamy herb sauce - all prepared on the stovetop! Very quick and easy recipe. Can improvise to certain tastes, and can serve for any occasion.",
                "http://images.media-allrecipes.com/userphotos/250x250/00/04/09/40947.jpg",
                4.31,
                false);

        RecipeInfo r2 = new RecipeInfo("Olive Salad for Muffalettas",
                "I created this olive salad recipe after a vacation to New Orleans. Muffaletta sandwiches are fabulously addictive! Sometimes I will assemble the sandwiches and broil them open faced until the meat is crisped and the cheese melted and toasty.",
                "http://images.media-allrecipes.com/userphotos/250x250/00/30/57/305716.jpg",
                2.62,
                true);

        List<RecipeInfo> lista = new ArrayList<RecipeInfo>();
        lista.add(r1);
        lista.add(r2);

        return lista;
    }

    private List<RecipeInfo> getDessert(){

        RecipeInfo r1 = new RecipeInfo("Easy Valentine's Day Cake",
                                        "Impress your favorite person on Valentine's day with a double-layer heart-shaped cake covered in homemade vanilla icing.",
                                        "http://images.media-allrecipes.com/userphotos/250x250/01/01/71/1017105.jpg",
                                        1.2,
                                        true);

        RecipeInfo r2 = new RecipeInfo("Brown Butter Cookies",
                                        "Using butter (NOT margarine) is essential for the success of this rich, but highly addictive cookie! You may need as little as 3 cups confectioners' sugar for the icing; just stop adding it when you've reached the desired consistency.",
                                        "http://images.media-allrecipes.com/userphotos/250x250/00/74/43/744345.jpg",
                                        4.71,
                                        true);

        List<RecipeInfo> lista = new ArrayList<RecipeInfo>();
        lista.add(r1);
        lista.add(r2);

        return lista;
    }

    private List<RecipeInfo> getEntertaining(){

        RecipeInfo r1 = new RecipeInfo("Pull-Apart Easter Blossom Bread",
                                        "A rich eggy dough is twisted into pretty flowers, then filled with jam and drizzled with lemon glaze for an Easter bread that will become a new tradition at your house. Pull it apart into petals to serve. Be sure to look at the pictures for how it is formed.",
                                        "http://images.media-allrecipes.com/userphotos/250x250/00/62/98/629896.jpg",
                                        3.31,
                                        false);

        RecipeInfo r2 = new RecipeInfo("Jelly Doughnuts",
                                        "Make this sweet nutmeg-flavored yeast dough in your bread machine or stand mixer. Then fill rounds of dough with your favorite jam, let them rise, and then fry them. Serve these doughnuts plain, sugared, or frosted.",
                                        "http://images.media-allrecipes.com/userphotos/250x250/00/18/73/187302.jpg",
                                        4.62,
                                        false);

        List<RecipeInfo> lista = new ArrayList<RecipeInfo>();
        lista.add(r1);
        lista.add(r2);

        return lista;
    }

    private List<RecipeInfo> getHealty(){

        RecipeInfo r1 = new RecipeInfo("Ceviche",
                                        "This recipe is a staple in Mexico. Raw seafood is cooked by the lime juice! Now don't wrinkle your nose! You would never know the seafood was not cooked prior to serving. Make sure to always use the freshest ingredients! You may substitute many types of seafood for scallops, for example: halibut, red snapper, flounder, or swordfish.",
                                        "http://images.media-allrecipes.com/userphotos/250x250/00/47/84/478483.jpg",
                                        3.00,
                                        true);

        RecipeInfo r2 = new RecipeInfo("Cherry Almond Oatmeal",
                                        "Old-fashioned rolled oats are cooked with vanilla almond milk and dried cherries for a family pleasing breakfast treat.",
                                        "http://images.media-allrecipes.com/userphotos/250x250/00/38/58/385823.jpg",
                                        5.00,
                                        false);

        List<RecipeInfo> lista = new ArrayList<RecipeInfo>();
        lista.add(r1);
        lista.add(r2);

        return lista;
    }
}

//ace