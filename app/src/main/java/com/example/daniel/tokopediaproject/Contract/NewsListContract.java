package com.example.daniel.tokopediaproject.Contract;

import com.example.daniel.tokopediaproject.Model.Articles;
import com.example.daniel.tokopediaproject.Model.MainResponse;

import java.util.List;

import retrofit2.Call;

public interface NewsListContract {
    interface View {
        
        void showProgressbar();

        void dismissProgressbar();

        void showSearchNewsResult(List<Articles> filteredArticleList);

        void onSuccessGetDataView(MainResponse mainResponse);

        void showDataBeforeFiltered();

        void showEmptyDataSearch();
    }

    interface Presenter {
        
        void onQueryTextChanged(String textchanged);

        void onSuccessGetData(MainResponse mainResponse);

        void onFailedGetData(String message);
    }

    interface Interactor {

        void callBusinessNewsAPI(Call call);

        void callBitCoinNewsAPI(Call call);

        void callTechCrunchNewsAPI(Call call);

        void callAppleNewsAPI(Call call);

        void callWallstreetNewsAPI(Call call);
    }
}
