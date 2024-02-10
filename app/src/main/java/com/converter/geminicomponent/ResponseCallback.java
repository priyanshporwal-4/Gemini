package com.converter.geminicomponent;

public interface ResponseCallback {

    void onResponse(String response);
    void onError(Throwable throwable);
}
