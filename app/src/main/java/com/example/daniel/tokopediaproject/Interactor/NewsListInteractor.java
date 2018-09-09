package com.example.daniel.tokopediaproject.Interactor;

import com.example.daniel.tokopediaproject.Connection.ConnectionCallbackPresenter;
import com.example.daniel.tokopediaproject.Connection.ConnectionManagerPresenter;
import com.example.daniel.tokopediaproject.Contract.NewsListContract;
import com.example.daniel.tokopediaproject.Model.MainResponse;

import retrofit2.Call;
import retrofit2.Response;

public class NewsListInteractor implements NewsListContract.Interactor {

    private NewsListContract.Presenter presenter;
    private ConnectionManagerPresenter connectionManagerPresenter;

    public NewsListInteractor(NewsListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void callBusinessNewsAPI(Call call) {
        connectionManagerPresenter = new ConnectionManagerPresenter();
        connectionManagerPresenter.connect(call, new ConnectionCallbackPresenter() {
            @Override
            public void onSuccessResponse(Call call, Response response) {
                MainResponse mainResponse = (MainResponse) response.body();
                presenter.onSuccessGetData(mainResponse);
            }

            @Override
            public void onFailedResponse(Call call, Response response) {
                presenter.onFailedGetData(response.message());
            }

            @Override
            public void onFailure(Call call, String message) {
                System.out.println("response failure : "+message);
            }
        });
    }

    @Override
    public void callBitCoinNewsAPI(Call call) {
        connectionManagerPresenter = new ConnectionManagerPresenter();
        connectionManagerPresenter.connect(call, new ConnectionCallbackPresenter() {
            @Override
            public void onSuccessResponse(Call call, Response response) {
                MainResponse mainResponse = (MainResponse) response.body();
                presenter.onSuccessGetData(mainResponse);
            }

            @Override
            public void onFailedResponse(Call call, Response response) {
                presenter.onFailedGetData(response.message());
            }

            @Override
            public void onFailure(Call call, String message) {

            }
        });
    }

    @Override
    public void callTechCrunchNewsAPI(Call call) {
        connectionManagerPresenter = new ConnectionManagerPresenter();
        connectionManagerPresenter.connect(call, new ConnectionCallbackPresenter() {
            @Override
            public void onSuccessResponse(Call call, Response response) {
                MainResponse mainResponse = (MainResponse) response.body();
                presenter.onSuccessGetData(mainResponse);
            }

            @Override
            public void onFailedResponse(Call call, Response response) {
                presenter.onFailedGetData(response.message());
            }

            @Override
            public void onFailure(Call call, String message) {

            }
        });
    }

    @Override
    public void callAppleNewsAPI(Call call) {
        connectionManagerPresenter = new ConnectionManagerPresenter();
        connectionManagerPresenter.connect(call, new ConnectionCallbackPresenter() {
            @Override
            public void onSuccessResponse(Call call, Response response) {
                MainResponse mainResponse = (MainResponse) response.body();
                presenter.onSuccessGetData(mainResponse);
            }

            @Override
            public void onFailedResponse(Call call, Response response) {
                presenter.onFailedGetData(response.message());
            }

            @Override
            public void onFailure(Call call, String message) {

            }
        });
    }

    @Override
    public void callWallstreetNewsAPI(Call call) {
        connectionManagerPresenter = new ConnectionManagerPresenter();
        connectionManagerPresenter.connect(call, new ConnectionCallbackPresenter() {
            @Override
            public void onSuccessResponse(Call call, Response response) {
                MainResponse mainResponse = (MainResponse) response.body();
                presenter.onSuccessGetData(mainResponse);
            }

            @Override
            public void onFailedResponse(Call call, Response response) {
                presenter.onFailedGetData(response.message());
            }

            @Override
            public void onFailure(Call call, String message) {

            }
        });
    }
}
