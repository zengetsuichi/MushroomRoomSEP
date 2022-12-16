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
    private final LiveData<Measurement> measurementsLiveData;
    private final LiveData<Co2Threshold> co2ThresholdLiveData;
    private final LiveData<HumidityThreshold> humidityThresholdLiveData;
    private final LiveData<LightThreshold> lightThresholdLiveData;
    private final LiveData<TemperatureThreshold> temperatureThresholdLiveData;
    private final LiveData<List<Measurement>> measurementHistoryListLiveData;

    public MeasurementFragmentViewModel(){
        measurementsLiveData = getMeasurementsLiveData();
        co2ThresholdLiveData = getCo2ThresholdLiveData();
        humidityThresholdLiveData = getHumidityThresholdLiveData();
        lightThresholdLiveData = getLightThresholdLiveData();
        temperatureThresholdLiveData = getTemperatureThresholdLiveData();
        measurementHistoryListLiveData = getMeasurementHistoryListLiveData();

    }

    public LiveData<Measurement> getMeasurementsLiveData(){
        return measurementRepository.getMeasurements();
    }
    public LiveData<Co2Threshold> getCo2ThresholdLiveData(){
        return measurementRepository.getCo2Threshold();
    }
    public LiveData<HumidityThreshold> getHumidityThresholdLiveData(){
        return measurementRepository.getHumidityThreshold();
    }
    public LiveData<LightThreshold> getLightThresholdLiveData(){
        return measurementRepository.getLightThreshold();
    }
    public LiveData<TemperatureThreshold> getTemperatureThresholdLiveData(){
        return measurementRepository.getTemperatureThreshold();
    }

    public LiveData<List<Measurement>> getMeasurementHistoryListLiveData(){
        return measurementRepository.getMeasurementHistory();
    }

}
