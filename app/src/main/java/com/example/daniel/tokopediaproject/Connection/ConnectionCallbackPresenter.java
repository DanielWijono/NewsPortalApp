package com.example.daniel.tokopediaproject.Connection;

import retrofit2.Call;
import retrofit2.Response;

public interface ConnectionCallbackPresenter {
    void onSuccessResponse(Call call, Response response);

    void onFailedResponse(Call call, Response response);

    void onFailure(Call call, String message);
}
