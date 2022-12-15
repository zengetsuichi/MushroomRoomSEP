package com.example.mushroomroomsep.network;

import com.example.mushroomroomsep.model.Measurement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MeasurementAPI {

    @GET("measurement")
    Call<List<Measurement>> getMeasurements();

}
