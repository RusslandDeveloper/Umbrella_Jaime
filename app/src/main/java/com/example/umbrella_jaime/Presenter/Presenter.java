package com.example.umbrella_jaime.Presenter;



import android.util.Log;

import com.example.umbrella_jaime.Interface_API;

import com.example.umbrella_jaime.Pojos.ForecastResponse;
import com.example.umbrella_jaime.SettingsFragment;
import com.example.umbrella_jaime.View.ViewContract;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Presenter implements PresenterContract {


        public static String country = "us";
        public static String id_key = "78f0a4b5ebd818e493cb432907b410af";


    Retrofit retrofit;
    ViewContract view;






    // Constructor
public Presenter(ViewContract view){this.view = view;



}

    private static final String TAG = "Presenter";


    @Override
    public void initializeRetrofit() {

        //Create an instance of retrofits.
    retrofit =new Retrofit.Builder().
            baseUrl(view.getBaseURL())
            .addConverterFactory(GsonConverterFactory.create()).
                    build();

    }





    @Override
    public void GetForecast( ) {
        Interface_API interface_api = retrofit.create(Interface_API.class);
        interface_api.GetForecastResponse(SettingsFragment.value_zip,country,SettingsFragment.value_metrics,
                id_key).enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if(response.body() != null) {
                   view.fillData(response.body().name,
                           response.body().tempKf)  ;
                        Log.i(TAG,"is this showing? -->  "+ response.body().temp);
                    Log.i(TAG,"is this showing? -->  "+ response.body().tempKf);
                    Log.i(TAG,"is this showing? -->  "+ response.body().tempMax);




                }
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {

                view.showError(t.getMessage());
            }
        });

    }
}
