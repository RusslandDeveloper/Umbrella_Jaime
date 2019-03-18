package com.example.umbrella_jaime;

import com.example.umbrella_jaime.Pojos.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface_API {



  @GET("weather?")
  Call<ForecastResponse>GetForecastResponse (@Query("zip") int zip, @Query("us")String country,
                                            @Query("units") String measures,
                                            @Query("APPID") String idkey  );





}
