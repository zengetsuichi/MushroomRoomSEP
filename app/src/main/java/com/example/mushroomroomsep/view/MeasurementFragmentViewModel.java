package com.example.mushroomroomsep.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.repository.MeasurementRepository;

import java.util.List;

public class MeasurementFragmentViewModel extends ViewModel {

    private static final String TAG = "MeasurementFragmentViewModel";

    private MeasurementRepository measurementRepository = MeasurementRepository.getInstance();
    private LiveData<List<Measurement>> measurementsLiveData;

    public MeasurementFragmentViewModel(){
        measurementsLiveData = measurementRepository.getMeasurements();

    }



    public LiveData<List<Measurement>> getAllMeasurements(){
        return measurementsLiveData;
    }
}
