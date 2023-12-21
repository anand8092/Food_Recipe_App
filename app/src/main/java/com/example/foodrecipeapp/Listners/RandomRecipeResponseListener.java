package com.example.foodrecipeapp.Listners;

import com.example.foodrecipeapp.Models.RandomRecipeApiResponse;

public interface RandomRecipeResponseListener {
    void didFetch(RandomRecipeApiResponse response, String message);
    void didError(String message);


}
