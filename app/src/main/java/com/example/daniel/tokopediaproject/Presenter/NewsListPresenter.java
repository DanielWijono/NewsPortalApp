package com.example.daniel.tokopediaproject.Presenter;

import com.example.daniel.tokopediaproject.Connection.RetrofitService;
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
                case "business":
                    call = RetrofitService.retrofitRequest().getBusinessNewsData();
                    interactor.callBusinessNewsAPI(call);
                    break;
                case "bitcoin":
                    call = RetrofitService.retrofitRequest().getBitcoinNewsData();
                    interactor.callBitCoinNewsAPI(call);
                    break;
                case "techcrunch":
                    call = RetrofitService.retrofitRequest().getTechCrunchNewsData();
                    interactor.callTechCrunchNewsAPI(call);
                    break;
                case "apple":
                    call = RetrofitService.retrofitRequest().getAppleNewsData();
                    interactor.callAppleNewsAPI(call);
                    break;
                case "wallstreet":
                    call = RetrofitService.retrofitRequest().getWallStreetNewsData();
                    interactor.callWallstreetNewsAPI(call);
                    break;
            }
        }
    }

    @Override
    public void onSuccessGetBusinessData(MainResponse mainResponse) {
        view.onSuccessGetBusinessDataView(mainResponse);
    }

    @Override
    public void onFailedGetBusinessData(String message) {

    }

    @Override
    public void onSuccessGetBitcoinData(MainResponse mainResponse) {
        view.onSuccessGetBitcoinDataView(mainResponse);
    }

    @Override
    public void onSuccessGetTechcrunchData(MainResponse mainResponse) {
        view.onSuccessGetTechcrunchDataView(mainResponse);
    }

    @Override
    public void onFailedGetTechcrunchData(String message) {

    }

    @Override
    public void onSuccessGetAppleData(MainResponse mainResponse) {
        view.onSuccessGetAppleDataView(mainResponse);
    }

    @Override
    public void onFailedGetAppleData(String message) {

    }

    @Override
    public void onSuccessGetWallstreetData(MainResponse mainResponse) {
        view.onSuccessGetWallstreetDataView(mainResponse);
    }

    @Override
    public void onFailedGetWallstreetData(String message) {

    }
}
