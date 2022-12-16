package com.example.mushroomroomsep;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import com.example.mushroomroomsep.view.MeasurementFragmentViewModel;



public class MeasurementFragment extends Fragment {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;


    MeasurementFragmentViewModel measurementFragmentViewModel = new MeasurementFragmentViewModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        measurementFragmentViewModel = new ViewModelProvider(requireActivity()).get(MeasurementFragmentViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.measurement_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        measurementFragmentViewModel.getMeasurementsLiveData().observe(getViewLifecycleOwner(), measurement -> {

            textView = (TextView) view.findViewById(R.id.measureId);
            textView2 = (TextView) view.findViewById(R.id.co2);
            textView3 = (TextView) view.findViewById(R.id.humidity);
            textView4 = (TextView) view.findViewById(R.id.temperature);
            textView5 = (TextView) view.findViewById(R.id.lightLevel);
            textView6 = (TextView) view.findViewById(R.id.timestamp);

            textView.setText(String.valueOf(measurement.getId()));
            textView2.setText(String.valueOf(measurement.getCo2()));
            textView3.setText(String.valueOf(measurement.getHumidity()));
            textView4.setText(String.valueOf(measurement.getTemperature()));
            textView5.setText(String.valueOf(measurement.getLightLevel()));
            textView6.setText(String.valueOf(measurement.getTimeStamp()));

        });

    }









}
