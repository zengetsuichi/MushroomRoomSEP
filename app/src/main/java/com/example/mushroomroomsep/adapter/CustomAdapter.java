package com.example.mushroomroomsep.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mushroomroomsep.R;
import com.example.mushroomroomsep.model.Measurement;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import com.example.mushroomroomsep.model.Measurement;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Measurement> implements View.OnClickListener{

    private ArrayList<Measurement> dataSet;
    Context mContext;

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Measurement dataModel=(Measurement)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getTimeStamp(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    // View lookup cache
    private static class ViewHolder {
        TextView measureId;
        TextView txtCo2;
        TextView humidity;
        TextView temperature;
        TextView lightLevel;
        TextView timestamp;
    }

    public CustomAdapter(ArrayList<Measurement> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Measurement dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.measureId = (TextView) convertView.findViewById(R.id.measureId);
            viewHolder.txtCo2 = (TextView) convertView.findViewById(R.id.co2);
            viewHolder.humidity = (TextView) convertView.findViewById(R.id.humidity);
            viewHolder.lightLevel= (TextView) convertView.findViewById(R.id.lightLevel);
            viewHolder.temperature= (TextView) convertView.findViewById(R.id.temperature);
            viewHolder.timestamp= (TextView) convertView.findViewById(R.id.timestamp);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;



        viewHolder.measureId.setText(dataModel.getId());
        viewHolder.txtCo2.setText((int) dataModel.getCo2());
        viewHolder.humidity.setText((int) dataModel.getHumidity());
        viewHolder.lightLevel.setText((int) dataModel.getLightLevel());
        viewHolder.temperature.setText((int) dataModel.getTemperature());

        // Return the completed view to render on screen
        return convertView;
    }
}

