package com.example.mushroomroomsep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mushroomroomsep.adapter.CustomAdapter;
import com.example.mushroomroomsep.model.Measurement;
import com.example.mushroomroomsep.view.MeasurementFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class MeasurementFragment extends Fragment {

    private MeasurementFragmentViewModel measurementFragmentViewModel;

    private ArrayList<Measurement> measurementResponse = new ArrayList<>();
    private ListView listView;
    private static CustomAdapter customAdapter;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("Hello from Fragment");



        measurementFragmentViewModel = new ViewModelProvider(this).get(MeasurementFragmentViewModel.class);
        measurementFragmentViewModel.getAllMeasurements().observe(getViewLifecycleOwner(), new Observer<List<Measurement>>() {
            @Override
            public void onChanged(List<Measurement> measurementResponse) {



            }
        });


        return inflater.inflate(R.layout.measurement_fragment, container, false);
    }

    public void initizalizeViews(View view){
        listView = view.findViewById(R.id.listView);
    }

}
