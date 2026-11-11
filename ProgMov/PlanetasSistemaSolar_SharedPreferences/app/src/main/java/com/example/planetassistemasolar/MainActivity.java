package com.example.planetassistemasolar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Fichero y clave de SharedPreferences
    private static final String FICHERO_PREFERENCIAS = "preferencias_planetas";
    private static final String CLAVE_ASCENDENTE = "ascendente";

    private Button btnProximidad;
    private Button btnTamano;
    private Button btnAlfabetico;

    private boolean ascendente = true; // tipo de ordenación elegido en el menú

    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnProximidad = (Button) findViewById(R.id.btnProximidad);
        btnTamano = (Button) findViewById(R.id.btnTamano);
        btnAlfabetico = (Button) findViewById(R.id.btnAlfabetico);

        // Los tres botones comparten el mismo onClick (como en CalculadoraProgramatica3)
        btnProximidad.setOnClickListener(this);
        btnTamano.setOnClickListener(this);
        btnAlfabetico.setOnClickListener(this);

        // Recuperamos la ordenación guardada la última vez (true = ascendente si es la 1ª vez)
        preferencias = getSharedPreferences(FICHERO_PREFERENCIAS, Context.MODE_PRIVATE);
        ascendente = preferencias.getBoolean(CLAVE_ASCENDENTE, true);
    }

    // ===================== BOTONES -> SEGUNDA ACTIVIDAD =====================

    @Override
    public void onClick(View v) {
        String criterio = "";
        if (v.getId() == R.id.btnProximidad) {
            criterio = ListadoPlanetas.CRITERIO_DISTANCIA;
        }
        if (v.getId() == R.id.btnTamano) {
            criterio = ListadoPlanetas.CRITERIO_TAMANO;
        }
        if (v.getId() == R.id.btnAlfabetico) {
            criterio = ListadoPlanetas.CRITERIO_ALFABETICO;
        }

        // Intent explícito (como en 12IntentExplicita): misma actividad para los 3 botones,
        // le pasamos el criterio y el sentido de la ordenación
        Intent intent = new Intent(getApplicationContext(), ListadoPlanetas.class);
        intent.putExtra("criterio", criterio);
        intent.putExtra("ascendente", ascendente);
        startActivity(intent);
    }

    // ===================== MENÚ PRINCIPAL =====================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = MainActivity.this.getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);
        // Marcamos la opción que está activa ahora mismo
        if (ascendente) {
            menu.findItem(R.id.itemAscendente).setChecked(true);
        } else {
            menu.findItem(R.id.itemDescendente).setChecked(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemAscendente) {
            ascendente = true;
            Toast.makeText(getApplicationContext(), "Ordenación Ascendente", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.itemDescendente) {
            ascendente = false;
            Toast.makeText(getApplicationContext(), "Ordenación Descendente", Toast.LENGTH_SHORT).show();
        }
        item.setChecked(true);
        guardarOrdenacion();
        return true;
    }

    // ===================== PERSISTENCIA (SharedPreferences) =====================

    private void guardarOrdenacion() {
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putBoolean(CLAVE_ASCENDENTE, ascendente);
        editor.apply();
    }
}
