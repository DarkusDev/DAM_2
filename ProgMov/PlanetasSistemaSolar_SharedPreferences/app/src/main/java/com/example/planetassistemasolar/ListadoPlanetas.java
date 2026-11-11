package com.example.planetassistemasolar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Segunda actividad: la MISMA para los tres botones.
 * Recibe por el Intent el criterio (distancia / tamaño / alfabético)
 * y si la ordenación es ascendente o descendente.
 */
public class ListadoPlanetas extends AppCompatActivity {

    public static final String CRITERIO_DISTANCIA = "distancia";
    public static final String CRITERIO_TAMANO = "tamano";
    public static final String CRITERIO_ALFABETICO = "alfabetico";

    // Datos proporcionados en datos.txt (se corresponden por posición)
    private String[] planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"}; // Ordenados por cercanía al Sol
    private long[] distancias = {57909175, 108208930, 149597870, 227936640, 778412010, 1426725400, 2870972200L, 4498252900L};
    private double[] diametros = {4879, 12103.6, 12756, 6794.4, 142985, 120534, 51114, 49532.72};

    private TextView tvTitulo;
    private ListView lvPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listado_planetas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        lvPlanetas = (ListView) findViewById(R.id.lvPlanetas);

        // Recogemos lo que nos manda MainActivity
        String criterio = CRITERIO_DISTANCIA;
        boolean ascendente = true;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            criterio = bundle.getString("criterio");
            ascendente = bundle.getBoolean("ascendente");
        }

        // 1) Juntamos los tres arrays en una lista de objetos ModeloPlaneta
        ArrayList<ModeloPlaneta> listaPlanetas = new ArrayList<ModeloPlaneta>();
        for (int i = 0; i < planetas.length; i++) {
            listaPlanetas.add(new ModeloPlaneta(planetas[i], distancias[i], diametros[i]));
        }

        // 2) Ordenamos según el criterio (siempre de menor a mayor / A-Z)
        String textoCriterio = "";
        if (criterio.equals(CRITERIO_DISTANCIA)) {
            textoCriterio = "distancia";
            Collections.sort(listaPlanetas, new Comparator<ModeloPlaneta>() {
                @Override
                public int compare(ModeloPlaneta p1, ModeloPlaneta p2) {
                    return Long.compare(p1.getDistancia(), p2.getDistancia());
                }
            });
        }
        if (criterio.equals(CRITERIO_TAMANO)) {
            textoCriterio = "tamaño";
            Collections.sort(listaPlanetas, new Comparator<ModeloPlaneta>() {
                @Override
                public int compare(ModeloPlaneta p1, ModeloPlaneta p2) {
                    return Double.compare(p1.getDiametro(), p2.getDiametro());
                }
            });
        }
        if (criterio.equals(CRITERIO_ALFABETICO)) {
            textoCriterio = "orden alfabético";
            Collections.sort(listaPlanetas, new Comparator<ModeloPlaneta>() {
                @Override
                public int compare(ModeloPlaneta p1, ModeloPlaneta p2) {
                    return p1.getNombre().compareToIgnoreCase(p2.getNombre());
                }
            });
        }

        // 3) Si es descendente, damos la vuelta a la lista ya ordenada
        if (!ascendente) {
            Collections.reverse(listaPlanetas);
        }

        // 4) Título de la pantalla
        tvTitulo.setText("Planetas por " + textoCriterio + (ascendente ? " (Ascendente)" : " (Descendente)"));

        // 5) Convertimos cada planeta en el texto que se ve en cada fila
        ArrayList<String> filas = new ArrayList<String>();
        for (ModeloPlaneta p : listaPlanetas) {
            if (criterio.equals(CRITERIO_DISTANCIA)) {
                filas.add(p.getNombre() + ": " + p.getDistancia() + " km");
            } else if (criterio.equals(CRITERIO_TAMANO)) {
                filas.add(p.getNombre() + ": " + p.getDiametro() + " km");
            } else {
                filas.add(p.getNombre());
            }
        }

        // 6) ListView con un ArrayAdapter de Strings (como en ListViewDeStrings)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filas);
        lvPlanetas.setAdapter(arrayAdapter);
    }
}
