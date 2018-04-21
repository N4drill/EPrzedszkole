package xyz.przedszkole.eprzedszkole.Model.Callback;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nadrill on 09.04.2018.
 */

public class RetrofitClient {


    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://przedszkole.xyz/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static RequestInterface getApiService() {
        return getRetrofitInstance().create(RequestInterface.class);
    }

}
