package com.example.daniel.tokopediaproject.Contract;

import com.example.daniel.tokopediaproject.Model.Articles;
import com.example.daniel.tokopediaproject.Model.MainResponse;

import java.util.List;

import retrofit2.Call;

public interface NewsListContract {
    interface View {

        void onSuccessGetBusinessDataView(MainResponse mainResponse);

        void onSuccessGetWallstreetDataView(MainResponse mainResponse);

        void onSuccessGetAppleDataView(MainResponse mainResponse);

        void onSuccessGetTechcrunchDataView(MainResponse mainResponse);

        void onSuccessGetBitcoinDataView(MainResponse mainResponse);

        void showProgressbar();

        void dismissProgressbar();

        void showSearchNewsResult(List<Articles> filteredArticleList);
    }

    interface Presenter {

        void onSuccessGetBusinessData(MainResponse mainResponse);

        void onFailedGetBusinessData(String message);

        void onSuccessGetBitcoinData(MainResponse mainResponse);

        void onSuccessGetTechcrunchData(MainResponse mainResponse);

        void onFailedGetTechcrunchData(String message);

        void onSuccessGetAppleData(MainResponse mainResponse);

        void onFailedGetAppleData(String message);

        void onSuccessGetWallstreetData(MainResponse mainResponse);

        void onFailedGetWallstreetData(String message);

        void onQueryTextChanged(String textchanged);
    }

    interface Interactor {

        void callBusinessNewsAPI(Call call);

        void callBitCoinNewsAPI(Call call);

        void callTechCrunchNewsAPI(Call call);

        void callAppleNewsAPI(Call call);

        void callWallstreetNewsAPI(Call call);
    }
}
