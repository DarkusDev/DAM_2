package com.example.listviewadaptadorpersonalizado;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        personas = new ArrayList<ModeloPersona>();
        ModeloPersona m1 = new ModeloPersona();
        m1.setNombre("Darius");
        m1.setCodigo(1);
        m1.setDescripcion("Hola soy Darius");
        m1.setFoto(2);

        personas.add(m1);

        lvAgenda=(ListView) findViewById(R.id.lvAgenda);
        ArrayAdapter<ModeloPersona> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, personas);
        lvAgenda.setAdapter(arrayAdapter);





    }
}