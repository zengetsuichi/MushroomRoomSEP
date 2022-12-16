package com.example.mushroomroomsep;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

    ListView lst;


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



        measurementFragmentViewModel.getMeasurementHistoryListLiveData().observe(getViewLifecycleOwner(), measurements -> {


            measurements = measurementFragmentViewModel.getMeasurementHistoryListLiveData().getValue();


//            id = (TextView) view.findViewById(R.id.measureId);
//            co2 = (TextView) view.findViewById(R.id.co2);
//            humidity = (TextView) view.findViewById(R.id.humidity);
//            lightLevel = (TextView) view.findViewById(R.id.lightLevel);
//            temperature = (TextView) view.findViewById(R.id.temperature);
//            timestamp = (TextView) view.findViewById(R.id.timestamp);
//
//
//
//                id.setText(String.valueOf(measurements.get(0).getId()));
//                co2.setText(String.valueOf(measurements.get(0).getCo2()));
//                humidity.setText(String.valueOf(measurements.get(0).getHumidity()));
//                lightLevel.setText(String.valueOf(measurements.get(0).getLightLevel()));
//                temperature.setText(String.valueOf(measurements.get(0).getTemperature()));
//                timestamp.setText(String.valueOf(measurements.get(0).getTimeStamp()));


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lst = (ListView) view.findViewById(R.id.listView);
            ArrayList<String> listItems = new ArrayList<String>();

            for(int i = 0; i<measurements.size(); i++) {
                listItems.add(String.valueOf(measurements.get(i).getId()));
                listItems.add(String.valueOf(measurements.get(i).getCo2()));
                listItems.add(String.valueOf(measurements.get(i).getHumidity()));
                listItems.add(String.valueOf(measurements.get(i).getLightLevel()));
                listItems.add(String.valueOf(measurements.get(i).getTemperature()));
                listItems.add(String.valueOf(measurements.get(i).getTimeStamp()));

            }


            ArrayAdapter ad = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listItems);

            lst.setAdapter(ad);






            getFragmentManager().beginTransaction().detach(this).attach(this).commit();


        });




    }












}
