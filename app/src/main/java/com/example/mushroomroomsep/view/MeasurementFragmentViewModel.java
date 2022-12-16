package com.example.mushroomroomsep.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mushroomroomsep.model.Co2Threshold;
import com.example.mushroomroomsep.model.HumidityThreshold;
import com.example.mushroomroomsep.model.LightThreshold;
import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.model.TemperatureThreshold;
import com.example.mushroomroomsep.repository.MeasurementRepository;

import java.util.List;

public class MeasurementFragmentViewModel extends ViewModel {

    private static final String TAG = "MeasurementFragmentViewModel";

    private final MeasurementRepository measurementRepository = MeasurementRepository.getInstance();

    private final LiveData<List<Measurement>> measurementHistoryListLiveData;

    public MeasurementFragmentViewModel(){

        measurementHistoryListLiveData = getMeasurementHistoryListLiveData();

    }


    public LiveData<List<Measurement>> getMeasurementHistoryListLiveData(){
        return measurementRepository.getMeasurementHistory();
    }

}
