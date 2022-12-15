package com.example.mushroomroomsep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.view.MeasurementFragmentViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MeasurementFragment extends Fragment {

    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private List<Measurement> measurementArrayList = new ArrayList<>();


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

        measurementFragmentViewModel.getAllMeasurements().observe(getViewLifecycleOwner(), new Observer<List<Measurement>>() {
            @Override
            public void onChanged(List<Measurement> measurements) {

                measurementArrayList = Collections.synchronizedList(measurements);



                textView = (TextView) view.findViewById(R.id.measureId);
                textView2 = (TextView) view.findViewById(R.id.timestamp);
                textView3 = (TextView) view.findViewById(R.id.lightLevel);
                textView4 = (TextView) view.findViewById(R.id.humidity);
                textView5 = (TextView) view.findViewById(R.id.co2);
                textView6 = (TextView) view.findViewById(R.id.temperature);

                System.out.println("Im in MeasurementFragment");
                textView.setText(measurements.get(0).getId());
                textView2.setText("chuj");
                textView3.setText("chuj");
                textView4.setText("chuj");
                textView5.setText("chuj");
                textView6.setText("chuj");

            }
        });

    }









}
