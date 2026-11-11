package com.example.sixnations4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adaptador personalizado: le dice al ListView CÓMO pintar cada ModeloJugador,
 * usando el diseño de res/layout/item_jugador.xml (nombre | país | puntos | bandera).
 */
public class AdaptadorJugador extends ArrayAdapter<ModeloJugador> {

    private Context context;
    private ArrayList<ModeloJugador> jugadores;

    public AdaptadorJugador(Context context, ArrayList<ModeloJugador> jugadores) {
        // El 2º parámetro es el layout de cada fila
        super(context, R.layout.item_jugador, jugadores);
        this.context = context;
        this.jugadores = jugadores;
    }

    // Se llama una vez por cada fila visible en pantalla
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;

        // Si no hay una fila reciclada, "inflamos" item_jugador.xml para crear una nueva
        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            item = inflater.inflate(R.layout.item_jugador, parent, false);
        }

        // Buscamos los elementos DENTRO de la fila (item.findViewById, no el de la Activity)
        TextView tvNombre = item.findViewById(R.id.tvNombre);
        TextView tvPais = item.findViewById(R.id.tvPais);
        TextView tvPuntos = item.findViewById(R.id.tvPuntos);
        ImageView imgvBandera = item.findViewById(R.id.imgvBandera);

        // Cogemos el jugador de esta posición y rellenamos la fila con sus datos
        ModeloJugador jugador = jugadores.get(position);
        tvNombre.setText(jugador.getNombre());
        tvPais.setText(MainActivity.PAISES[jugador.getPais()]);
        tvPuntos.setText(jugador.getPuntos() + "\npuntos");
        imgvBandera.setImageResource(MainActivity.BANDERAS[jugador.getPais()]);

        return item;
    }
}
