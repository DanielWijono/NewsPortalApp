package com.example.daniel.tokopediaproject.Interactor;

import com.example.daniel.tokopediaproject.Contract.HomeContract;

public class HomeInteractor implements HomeContract.Interactor {

    private HomeContract.Presenter presenter;
    //private ConnectionManagerPresenter mConnectionManager;

    public HomeInteractor(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
