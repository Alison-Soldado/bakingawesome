package com.example.alissonsoldado.bakingawesome.data.source.remote;

import com.example.alissonsoldado.bakingawesome.BuildConfig;

public class Api {

    public WebService getBankingService() {
        return CallApi.getClient(BuildConfig.BASE_URL).create(WebService.class);
    }
}
