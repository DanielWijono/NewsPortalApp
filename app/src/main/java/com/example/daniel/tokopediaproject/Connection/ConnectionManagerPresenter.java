package com.example.daniel.tokopediaproject.Connection;

import android.util.Log;

import com.example.daniel.tokopediaproject.Constants;
import com.example.daniel.tokopediaproject.Model.MainResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ConnectionManagerPresenter {
    private ConnectionCallbackPresenter mConnectionCallback;
    private Call mCall;
    private String status;

    public void connect( Call mCall,  ConnectionCallbackPresenter mConnectionCallback) {
        this.mCall = mCall;
        this.mConnectionCallback = mConnectionCallback;
        callAPIRequest();
    }

    public void callAPIRequest() {

        mCall.clone().enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.i(TAG, "Response code : "+ response.code());
                Log.i(TAG, "Response url  : "+ response.raw().request().url().toString());

                if (response.isSuccessful()) { //ONLY FOR RESPONSE CODE 200
                    System.out.println("Response success");
                    MainResponse mainResponse = (MainResponse) response.body();

                    status = mainResponse.getStatus();

//                    if(status.equals(Constants.Result.SUCCESS)) {
//                        Log.i(TAG, "SUCCESS : " + UserPreference.getInstance().getAccessToken());
//
//                        if(mainResponse.getAccessToken() != null) {
//                            UserPreference.getInstance().setAccessToken(mainResponse.getAccessToken());
//                            Log.i(TAG, "REFRESH TOKEN " + UserPreference.getInstance().getAccessToken());
//                        }

                    mConnectionCallback.onSuccessResponse(call, response);

                } else {
                    mConnectionCallback.onFailedResponse(call, response);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                mConnectionCallback.onFailure(call, t.getMessage());
            }
        });
    }
}
