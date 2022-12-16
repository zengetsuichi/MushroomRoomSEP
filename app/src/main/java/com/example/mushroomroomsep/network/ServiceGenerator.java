package com.example.mushroomroomsep.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static MeasurementAPI measurementAPI;

  private static String BASE_URL = "http://192.168.87.102:8081/api/v1/";


    public static MeasurementAPI getMeasurementAPI(){
        if(measurementAPI == null) {
            measurementAPI = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MeasurementAPI.class);
            System.out.println("Api instance lazy iniciated");
        }
        return measurementAPI;
    }
}
