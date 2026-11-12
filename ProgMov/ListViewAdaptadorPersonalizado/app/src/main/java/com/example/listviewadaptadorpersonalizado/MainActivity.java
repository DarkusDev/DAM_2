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
import java.util.HashMap;
import java.util.Map;

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


        personas = new ArrayList<ModeloPersona>();
        Map<String, Double> notas1 = new HashMap<>();
        notas1.put("Matemáticas", 8.5);
        notas1.put("Programación", 9.0);
        notas1.put("Bases de Datos", 7.5);
        personas.add(new ModeloPersona("Carlos Perez", "12345678A", R.drawable.a01, notas1));

        // Alumno 2
        Map<String, Double> notas2 = new HashMap<>();
        notas2.put("Matemáticas", 6.0);
        notas2.put("Programación", 7.0);
        notas2.put("Bases de Datos", 6.5);
        personas.add(new ModeloPersona("Ana Gómez", "87654321B", R.drawable.a02, notas2));

// Alumno 3
        Map<String, Double> notas3 = new HashMap<>();
        notas3.put("Matemáticas", 9.5);
        notas3.put("Programación", 10.0);
        notas3.put("Bases de Datos", 9.0);
        personas.add(new ModeloPersona("Luis Martínez", "45678912C", R.drawable.a03, notas3));

// Alumno 4
        Map<String, Double> notas4 = new HashMap<>();
        notas4.put("Matemáticas", 5.0);
        notas4.put("Programación", 6.0);
        notas4.put("Bases de Datos", 4.5);
        personas.add(new ModeloPersona("María Rodríguez", "32165498D", R.drawable.a04, notas4));

// Alumno 5
        Map<String, Double> notas5 = new HashMap<>();
        notas5.put("Matemáticas", 7.0);
        notas5.put("Programación", 8.0);
        notas5.put("Bases de Datos", 8.5);
        personas.add(new ModeloPersona("Jorge Sánchez", "78912345E", R.drawable.a05, notas5));

// Alumno 6
        Map<String, Double> notas6 = new HashMap<>();
        notas6.put("Matemáticas", 8.0);
        notas6.put("Programación", 7.5);
        notas6.put("Bases de Datos", 9.0);
        personas.add(new ModeloPersona("Lucía Fernández", "65432187F", R.drawable.a06, notas6));

// Alumno 7
        Map<String, Double> notas7 = new HashMap<>();
        notas7.put("Matemáticas", 4.5);
        notas7.put("Programación", 5.5);
        notas7.put("Bases de Datos", 6.0);
        personas.add(new ModeloPersona("David López", "14725836G", R.drawable.a07, notas7));

// Alumno 8
        Map<String, Double> notas8 = new HashMap<>();
        notas8.put("Matemáticas", 9.0);
        notas8.put("Programación", 9.5);
        notas8.put("Bases de Datos", 9.5);
        personas.add(new ModeloPersona("Elena Gómez", "36925814H", R.drawable.a08, notas8));

// Alumno 9
        Map<String, Double> notas9 = new HashMap<>();
        notas9.put("Matemáticas", 6.5);
        notas9.put("Programación", 6.0);
        notas9.put("Bases de Datos", 7.0);
        personas.add(new ModeloPersona("Pablo Torres", "95175385I", R.drawable.a09, notas9));

// Alumno 10
        Map<String, Double> notas10 = new HashMap<>();
        notas10.put("Matemáticas", 7.5);
        notas10.put("Programación", 8.5);
        notas10.put("Bases de Datos", 8.0);
        personas.add(new ModeloPersona("Sofía Ruiz", "75395124J", R.drawable.a10, notas10));


        lvAgenda = (ListView) findViewById(R.id.lvAgenda);
        AdaptadorPersona adaptador = new AdaptadorPersona(this, personas);
        lvAgenda.setAdapter(adaptador);

        lvAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModeloPersona p = personas.get(position);
                Intent intent = new Intent(getApplicationContext(), DetallePersona.class);
                intent.putExtra("nombre", p.getNombre());
                intent.putExtra("descripcion", p.getDNI());
                intent.putExtra("notaIndM", 5);
                intent.putExtra("notaIndP", 6);
                intent.putExtra("notaIndB", 7);

                intent.putExtra("mediaM", 5);
                intent.putExtra("mediaM", 6);
                intent.putExtra("mediaM", 7);

                intent.putExtra("variacionM", 5);
                intent.putExtra("variacionM", 6);
                intent.putExtra("variacionM", 7);
                intent.putExtra("foto", p.getFoto());
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Has elegido a " + p.getNombre(), Toast.LENGTH_LONG).show();
            }
        });
    }
}