package com.example.mushroomroomsep.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mushroomroomsep.R;
import com.example.mushroomroomsep.model.Measurement;

import java.util.ArrayList;


public class MeasurementListAdapter extends RecyclerView.Adapter<MeasurementListAdapter.ViewHolder> {
    private ArrayList<Measurement> measurements;

    public MeasurementListAdapter(ArrayList<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public MeasurementListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.tv_titulo.setText(cupon.get(i).getTitulo());
        holder.tv_empresa.setText(cupon.get(i).getEmpresa());
        holder.tv_descripcion.setText(cupon.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return cupon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_titulo, tv_descripcion, tv_empresa;

        public ViewHolder(View view) {
            super(view);
            tv_titulo = (TextView) view.findViewById(R.id.tv_titulo);
            tv_descripcion = (TextView) view.findViewById(R.id.tv_descripcion);
            tv_empresa = (TextView) view.findViewById(R.id.tv_empresa);
        }
    }
}
