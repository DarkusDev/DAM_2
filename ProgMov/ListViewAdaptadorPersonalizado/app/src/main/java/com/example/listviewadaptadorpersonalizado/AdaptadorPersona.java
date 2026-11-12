package com.example.listviewadaptadorpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdaptadorPersona extends ArrayAdapter<ModeloPersona> {

    private Context context;
    private ArrayList<ModeloPersona> personas;

    public AdaptadorPersona(Context context, ArrayList<ModeloPersona> personas) {

        super(context, R.layout.item, personas);
        this.context = context;
        this.personas = personas;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;


        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            item = inflater.inflate(R.layout.item, parent, false);
        }


        ImageView imgvFoto = item.findViewById(R.id.imgvFoto);
        TextView tvNombre = item.findViewById(R.id.tvNombre);
        TextView tvDescripcion = item.findViewById(R.id.tvDescripcion);
        TextView tvNotaMedia = item.findViewById(R.id.tvNotaMedia);


        ModeloPersona persona = personas.get(position);
        imgvFoto.setImageResource(persona.getFoto());
        tvNombre.setText(persona.getNombre());
        tvDescripcion.setText(persona.getDNI());
        tvNotaMedia.setText("" + persona.getNotaMedia());

        return item;
    }
}