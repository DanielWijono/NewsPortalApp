package com.example.daniel.tokopediaproject.Presenter;

import com.example.daniel.tokopediaproject.Connection.RetrofitService;
import com.example.daniel.tokopediaproject.Constants;
import com.example.daniel.tokopediaproject.Contract.NewsListContract;
import com.example.daniel.tokopediaproject.Interactor.NewsListInteractor;
import com.example.daniel.tokopediaproject.Model.MainResponse;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import retrofit2.Call;
import retrofit2.Retrofit;

public class NewsListPresenter implements NewsListContract.Presenter {

    private NewsListContract.View view;
    private NewsListContract.Interactor interactor;

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
    public void onSuccessGetBusinessData(MainResponse mainResponse) {
        view.dismissProgressbar();
        view.onSuccessGetBusinessDataView(mainResponse);
    }

    @Override
    public void onFailedGetBusinessData(String message) {
        view.dismissProgressbar();
    }

    @Override
    public void onSuccessGetBitcoinData(MainResponse mainResponse) {
        view.dismissProgressbar();
        view.onSuccessGetBitcoinDataView(mainResponse);
    }

    @Override
    public void onSuccessGetTechcrunchData(MainResponse mainResponse) {
        view.dismissProgressbar();
        view.onSuccessGetTechcrunchDataView(mainResponse);
    }

    @Override
    public void onFailedGetTechcrunchData(String message) {
        view.dismissProgressbar();
    }

    @Override
    public void onSuccessGetAppleData(MainResponse mainResponse) {
        view.dismissProgressbar();
        view.onSuccessGetAppleDataView(mainResponse);
    }

    @Override
    public void onFailedGetAppleData(String message) {
        view.dismissProgressbar();
    }

    @Override
    public void onSuccessGetWallstreetData(MainResponse mainResponse) {
        view.dismissProgressbar();
        view.onSuccessGetWallstreetDataView(mainResponse);
    }

    @Override
    public void onFailedGetWallstreetData(String message) {
        view.dismissProgressbar();
    }
}
