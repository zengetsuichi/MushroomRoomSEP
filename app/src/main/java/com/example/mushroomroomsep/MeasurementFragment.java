package com.example.mushroomroomsep;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.view.MeasurementFragmentViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MeasurementFragment extends Fragment {


    private TextView id;
    private TextView co2;
    private TextView humidity;
    private TextView lightLevel;
    private TextView temperature;
    private TextView timestamp;


    MeasurementFragmentViewModel measurementFragmentViewModel = new MeasurementFragmentViewModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        measurementFragmentViewModel = new ViewModelProvider(requireActivity()).get(MeasurementFragmentViewModel.class);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        return inflater.inflate(R.layout.measurement_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        measurementFragmentViewModel.getMeasurementHistoryListLiveData().observe(getViewLifecycleOwner(), measurements -> {


            id = (TextView) view.findViewById(R.id.measureId);
            co2 = (TextView) view.findViewById(R.id.co2);
            humidity = (TextView) view.findViewById(R.id.humidity);
            lightLevel = (TextView) view.findViewById(R.id.lightLevel);
            temperature = (TextView) view.findViewById(R.id.temperature);
            timestamp = (TextView) view.findViewById(R.id.timestamp);


            id.setText(String.valueOf(measurements.get(1).getId()));
            co2.setText(String.valueOf(measurements.get(1).getCo2()));
            humidity.setText(String.valueOf(measurements.get(1).getHumidity()));
            lightLevel.setText(String.valueOf(measurements.get(1).getLightLevel()));
            temperature.setText(String.valueOf(measurements.get(1).getTemperature()));
            timestamp.setText(String.valueOf(measurements.get(1).getTimeStamp()));

        });



    }











}
