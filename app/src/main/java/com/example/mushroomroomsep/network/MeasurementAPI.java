package com.example.mushroomroomsep.network;

import com.example.mushroomroomsep.model.Co2Threshold;
import com.example.mushroomroomsep.model.HumidityThreshold;
import com.example.mushroomroomsep.model.LightThreshold;
import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.model.TemperatureThreshold;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MeasurementAPI {

    @GET("Measurement")
    Call<Measurement> getMeasurements();

    @GET("Co2ThreshhoId")
    Call<Co2Threshold> getCo2ThresholdId();

    @GET("HumidityThreshold")
    Call<HumidityThreshold> getHumidityThreshold();

    @GET("LightThreshold")
    Call<LightThreshold> getLightThreshold();

    @GET("TemperatureThreshold")
    Call<TemperatureThreshold> getTemperatureThreshold();

    @GET("Measurement/history")
    Call<List<Measurement>> getMeasurementHistory();



}
