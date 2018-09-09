package com.example.daniel.tokopediaproject.Presenter;

import com.example.daniel.tokopediaproject.Contract.HomeContract;
import com.example.daniel.tokopediaproject.Interactor.HomeInteractor;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private HomeContract.Interactor interactor;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        interactor = new HomeInteractor(this);
    }

    @Override
    public void validatePositionClick(int position) {
        switch (position) {
            case 0:
                view.intentToBusinessNews();
                break;
            case 1:
                view.intentToBitcoinNews();
                break;
            case 2:
                view.intentToTechCrunchNews();
                break;
            case 3:
                view.intentToAppleNews();
                break;
            case 4:
                view.intentToWallStreetNews();
                break;
        }
    }
}
