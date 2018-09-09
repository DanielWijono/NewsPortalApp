package com.example.daniel.tokopediaproject;

import com.example.daniel.tokopediaproject.Model.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICollections {

    @GET(Constants.URL_API.BUSINESS)
    Call<MainResponse> getBusinessNewsData();

    @GET(Constants.URL_API.BITCOIN)
    Call<MainResponse> getBitcoinNewsData();

    @GET(Constants.URL_API.APPLE)
    Call<MainResponse> getAppleNewsData();

    @GET(Constants.URL_API.TECHCRUNCH)
    Call<MainResponse> getTechCrunchNewsData();

    @GET(Constants.URL_API.WALLSTREET)
    Call<MainResponse> getWallStreetNewsData();
}
