package com.example.daniel.tokopediaproject.Presenter;

import com.example.daniel.tokopediaproject.Connection.RetrofitService;
import com.example.daniel.tokopediaproject.Constants;
import com.example.daniel.tokopediaproject.Contract.NewsListContract;
import com.example.daniel.tokopediaproject.Interactor.NewsListInteractor;
import com.example.daniel.tokopediaproject.Model.Articles;
import com.example.daniel.tokopediaproject.Model.MainResponse;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;

public class NewsListPresenter implements NewsListContract.Presenter {

    private NewsListContract.View view;
    private NewsListContract.Interactor interactor;
    private List<Articles> articlesList = new ArrayList<>();
    private List<Articles> filteredArticleList = new ArrayList<>();

    public NewsListPresenter(NewsListContract.View view) {
        this.view = view;
        interactor = new NewsListInteractor(this);
    }

    public void validationNewsValue(String newsValue) {
        Call call;
        if (newsValue != null) {
            switch (newsValue) {
                case Constants.NEWS_TYPE.BUSINESS_NEWS:
                    view.showProgressbar();
                    call = RetrofitService.retrofitRequest().getBusinessNewsData();
                    interactor.callBusinessNewsAPI(call);
                    break;
                case Constants.NEWS_TYPE.BITCOIN_NEWS:
                    view.showProgressbar();
                    call = RetrofitService.retrofitRequest().getBitcoinNewsData();
                    interactor.callBitCoinNewsAPI(call);
                    break;
                case Constants.NEWS_TYPE.TECHCRUNCH_NEWS:
                    view.showProgressbar();
                    call = RetrofitService.retrofitRequest().getTechCrunchNewsData();
                    interactor.callTechCrunchNewsAPI(call);
                    break;
                case Constants.NEWS_TYPE.APPLE_NEWS:
                    view.showProgressbar();
                    call = RetrofitService.retrofitRequest().getAppleNewsData();
                    interactor.callAppleNewsAPI(call);
                    break;
                case Constants.NEWS_TYPE.WALLSTREET_NEWS:
                    view.showProgressbar();
                    call = RetrofitService.retrofitRequest().getWallStreetNewsData();
                    interactor.callWallstreetNewsAPI(call);
                    break;
            }
        }
    }

    @Override
    public void onSuccessGetData(MainResponse mainResponse) {
        articlesList = mainResponse.getArticlesList();
        view.dismissProgressbar();
        view.onSuccessGetDataView(mainResponse);
    }

    @Override
    public void onFailedGetData(String message) {
        view.dismissProgressbar();
    }

    @Override
    public void onQueryTextChanged(String textchanged) {
        if (textchanged.length() >=1) {
            getFilterSearch(textchanged);
       } else {
            view.showDataBeforeFiltered();
        }
    }

    private void getFilterSearch(String textchanged) {
        filteredArticleList.clear();
        for (int i = 0 ; i < articlesList.size(); i++) {
            if (articlesList.get(i).getTitle() != null) {
                if (articlesList.get(i).getTitle().toLowerCase().contains(textchanged.toLowerCase())) {
                    filteredArticleList.add(articlesList.get(i));
                }
            }
        }
        if (filteredArticleList.size() > 0) {
            view.showSearchNewsResult(filteredArticleList);
        } else {
            view.showEmptyDataSearch();
        }
    }
}
