package com.example.daniel.tokopediaproject.Contract;

public interface HomeContract {
    interface View {

        void intentToBusinessNews();

        void intentToBitcoinNews();

        void intentToTechCrunchNews();

        void intentToAppleNews();

        void intentToWallStreetNews();
    }

    interface Presenter {
        void validatePositionClick(int position);
    }

    interface Interactor {

    }
}
