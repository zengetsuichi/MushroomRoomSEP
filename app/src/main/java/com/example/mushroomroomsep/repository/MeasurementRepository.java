package com.example.mushroomroomsep.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mushroomroomsep.model.Co2Threshold;
import com.example.mushroomroomsep.model.HumidityThreshold;
import com.example.mushroomroomsep.model.LightThreshold;
import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.model.TemperatureThreshold;
import com.example.mushroomroomsep.network.MeasurementAPI;
import com.example.mushroomroomsep.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeasurementRepository {

    private static final String TAG = "MeasurementRepository";
    private static final MeasurementRepository ourInstance = new MeasurementRepository();
    private final MeasurementAPI api;


    private final MutableLiveData<List<Measurement>> measurementHistoryList = new MutableLiveData<>();


    public static MeasurementRepository getInstance() {
        return ourInstance;
    }

    public MeasurementRepository() {
        api = ServiceGenerator.getMeasurementAPI();
    }


//    public LiveData<LightThreshold> getLightThreshold() {
//
//        api.getLightThreshold().enqueue(new Callback<LightThreshold>() {
//            @Override
//            public void onResponse(@NonNull Call<LightThreshold> call, @NonNull Response<LightThreshold> response) {
//                if (response.code() == 200) {
//                    lightListLiveData.postValue(response.body());
//                    System.out.println("LightThreshold obtained succesfully");
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<LightThreshold> call, Throwable t) {
//                Log.i(TAG, "onFailure: failed to fetch LightThreshold from server");
//                System.out.println(t.getMessage());
//            }
//        });
//        return lightListLiveData;
//    }
//
//
//    public LiveData<HumidityThreshold> getHumidityThreshold() {
//
//        api.getHumidityThreshold().enqueue(new Callback<HumidityThreshold>() {
//            @Override
//            public void onResponse(@NonNull Call<HumidityThreshold> call, @NonNull Response<HumidityThreshold> response) {
//                if (response.code() == 200) {
//                    humidityListLiveData.postValue(response.body());
//                    System.out.println("HumidityThreshold obtained succesfully");
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<HumidityThreshold> call, Throwable t) {
//                Log.i(TAG, "onFailure: failed to fetch HumidityThreshold list from server");
//                System.out.println(t.getMessage());
//            }
//        });
//        return humidityListLiveData;
//    }
//
//    public LiveData<Measurement> getMeasurements() {
//
//        api.getMeasurements().enqueue(new Callback<Measurement>() {
//            @Override
//            public void onResponse(@NonNull Call<Measurement> call, @NonNull Response<Measurement> response) {
//                if (response.code() == 200) {
//                    measurementListLiveData.postValue(response.body());
//                    System.out.println("Measurment obtained succesfully");
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Measurement> call, Throwable t) {
//                Log.i(TAG, "onFailure: failed to fetch measurments list from server");
//                System.out.println(t.getMessage());
//            }
//        });
//        return measurementListLiveData;
//    }
//
//    public LiveData<Co2Threshold> getCo2Threshold() {
//
//        api.getCo2ThresholdId().enqueue(new Callback<Co2Threshold>() {
//            @Override
//            public void onResponse(@NonNull Call<Co2Threshold> call, @NonNull Response<Co2Threshold> response) {
//                if (response.code() == 200) {
//                    co2ListLiveData.postValue(response.body());
//                    System.out.println("Co2Threshold obtained succesfully");
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Co2Threshold> call, Throwable t) {
//                Log.i(TAG, "onFailure: failed to fetch Co2Threshold list from server");
//                System.out.println(t.getMessage());
//            }
//        });
//        return co2ListLiveData;
//    }
//
//    public LiveData<TemperatureThreshold> getTemperatureThreshold() {
//
//        api.getTemperatureThreshold().enqueue(new Callback<TemperatureThreshold>() {
//            @Override
//            public void onResponse(@NonNull Call<TemperatureThreshold> call, @NonNull Response<TemperatureThreshold> response) {
//                if (response.code() == 200) {
//                    temperatureListLiveData.postValue(response.body());
//                    System.out.println("TemperatureThreshold obtained succesfully");
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<TemperatureThreshold> call, Throwable t) {
//                Log.i(TAG, "onFailure: failed to fetch TemperatureThreshold list from server");
//                System.out.println(t.getMessage());
//            }
//        });
//        return temperatureListLiveData;
//    }

    public LiveData<List<Measurement>> getMeasurementHistory() {

        api.getMeasurementHistory().enqueue(new Callback<List<Measurement>>() {
            @Override
            public void onResponse(@NonNull Call<List<Measurement>> call, @NonNull Response<List<Measurement>> response) {
                if (response.code() == 200) {
                    measurementHistoryList.postValue(response.body());
                    System.out.println("MeasurementHistory obtained succesfully");
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Measurement>> call, Throwable t) {
                Log.i(TAG, "onFailure: failed to fetch MeasurementHistory list from server");
                System.out.println(t.getMessage());
            }
        });
        return measurementHistoryList;
    }



}
