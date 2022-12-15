package com.example.mushroomroomsep.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.network.MeasurementAPI;
import com.example.mushroomroomsep.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeasurementRepository {

    private static final String TAG = "MeasurementRepository";
    private static final MeasurementRepository ourInstance = new MeasurementRepository();
    private MeasurementAPI api;

    private MutableLiveData<List<Measurement>> measurementListLiveData = new MutableLiveData<>();

    public static MeasurementRepository getInstance(){
        return ourInstance;
    }

    public MeasurementRepository(){
        api = ServiceGenerator.getMeasurementAPI();
    }


    public LiveData<List<Measurement>> getMeasurements() {

        api.getMeasurements().enqueue(new Callback<List<Measurement>>() {
            @Override
            public void onResponse(@NonNull Call<List<Measurement>> call, @NonNull Response<List<Measurement>> response) {
                if(response.code() == 200) {
                    measurementListLiveData.postValue(response.body());
                    System.out.println("Measurment obtained succesfully");
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Measurement>> call, Throwable t) {
                Log.i(TAG, "onFailure: failed to fetch measurments list from server");
                System.out.println(t.getMessage());
            }
        });
        return measurementListLiveData;
    }
}
