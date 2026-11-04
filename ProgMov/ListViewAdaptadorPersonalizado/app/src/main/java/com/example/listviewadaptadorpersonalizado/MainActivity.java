package com.example.listviewadaptadorpersonalizado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvAgenda;
    private ArrayList<ModeloPersona> personas;

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

        // Datos: la foto es un recurso R.drawable (cámbialo por fotos reales si las añades)
        personas = new ArrayList<ModeloPersona>();
        personas.add(new ModeloPersona("Darius", "Hola soy Darius", 1, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Karla", "Hola soy Karla", 2, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Vlad", "Hola soy Vlad", 3, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Javi", "Hola soy Javi", 4, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Leo", "Hola soy Leo", 5, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Dani", "Hola soy Dani", 6, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Alina", "Hola soy Alina", 7, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Adrian", "Hola soy Adrian", 8, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Pepito", "Hola soy Pepito", 9, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Juanito", "Hola soy Juanito", 10, R.drawable.ic_persona));
        personas.add(new ModeloPersona("Carlos", "Hola soy Carlos", 11, R.drawable.ic_persona));

        // En vez de un ArrayAdapter normal, usamos nuestro adaptador personalizado
        lvAgenda = (ListView) findViewById(R.id.lvAgenda);
        AdaptadorPersona adaptador = new AdaptadorPersona(this, personas);
        lvAgenda.setAdapter(adaptador);

        lvAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModeloPersona p = personas.get(position);
                Intent intent = new Intent(getApplicationContext(), DetallePersona.class);
                intent.putExtra("nombre", p.getNombre());
                intent.putExtra("descripcion", p.getDescripcion());
                intent.putExtra("codigo", p.getCodigo());
                intent.putExtra("foto", p.getFoto());
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Has elegido a " + p.getNombre(), Toast.LENGTH_LONG).show();
            }
        });
    }
}