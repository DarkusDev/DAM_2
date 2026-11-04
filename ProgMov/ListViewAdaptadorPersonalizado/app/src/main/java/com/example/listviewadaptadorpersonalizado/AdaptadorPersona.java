package com.example.listviewadaptadorpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adaptador personalizado: le dice al ListView CÓMO pintar cada ModeloPersona,
 * usando el diseño de res/layout/item.xml en lugar del toString().
 */
public class AdaptadorPersona extends ArrayAdapter<ModeloPersona> {

    private Context context;
    private ArrayList<ModeloPersona> personas;

    public AdaptadorPersona(Context context, ArrayList<ModeloPersona> personas) {
        // El 2º parámetro es el layout de cada fila
        super(context, R.layout.item, personas);
        this.context = context;
        this.personas = personas;
    }

    // Se llama una vez por cada fila visible en pantalla
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;

        // Si no hay una fila reciclada, "inflamos" item.xml para crear una nueva
        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            item = inflater.inflate(R.layout.item, parent, false);
        }

        // Buscamos los elementos DENTRO de la fila (item.findViewById, no el de la Activity)
        ImageView imgvFoto = item.findViewById(R.id.imgvFoto);
        TextView tvNombre = item.findViewById(R.id.tvNombre);
        TextView tvDescripcion = item.findViewById(R.id.tvDescripcion);
        TextView tvCodigo = item.findViewById(R.id.tvCodigo);

        // Cogemos la persona de esta posición y rellenamos la fila con sus datos
        ModeloPersona persona = personas.get(position);
        imgvFoto.setImageResource(persona.getFoto());
        tvNombre.setText(persona.getNombre());
        tvDescripcion.setText(persona.getDescripcion());
        tvCodigo.setText("#" + persona.getCodigo());

        return item;
    }
}