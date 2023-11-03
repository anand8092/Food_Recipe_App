package com.example.foodrecipeapp.Activity;

import android.content.Context;

import com.example.foodrecipeapp.Listners.RandomRecipeResponseListener;
import com.example.foodrecipeapp.Models.RandomRecipeApiResponse;
import com.example.foodrecipeapp.R;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {

    Context context;
    Retrofit retrofit =new  Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getRandomReceipes(RandomRecipeResponseListener Listener, List<String> tags){
        CallRandomRecipes callRandomRecipes =retrofit.create(CallRandomRecipes.class);
        String number;
        Call<RandomRecipeApiResponse> call = callRandomRecipes.callRandomRecipe(context.getString(R.string.api_key), "10", tags);
        call.enqueue(new Callback<RandomRecipeApiResponse>() {
            @Override
            public void onResponse(Call<RandomRecipeApiResponse> call, Response<RandomRecipeApiResponse> response) {
                if(!response.isSuccessful()){
                    Listener.didError(response.message());
                    return;
                }
                Listener.didFitch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<RandomRecipeApiResponse> call, Throwable t) {
                Listener.didError(t.getMessage());
            }
        });

    }
    private interface CallRandomRecipes{
        @GET("recipes/random")
        Call<RandomRecipeApiResponse> callRandomRecipe(
                @Query("apiKey") String apiKey,
                @Query("number") String number,
                @Query("tags")List<String> tags
                );
    }

}
