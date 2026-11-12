package com.example.listviewdestrings;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[]nombres = {"Darius", "Karla", "Vlad"};
    private String[]sexos = {"M", "F", "M"};
    private String[]telefonos = {"671", "672", "673"};
    private ListView lvAgenda;

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

        lvAgenda = (ListView) findViewById(R.id.lvAgenda);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, nombres);
        lvAgenda.setAdapter(arrayAdapter);

        lvAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "El teléfono elegido es: " + telefonos[position], Toast.LENGTH_LONG).show();
            }
        });

        lvAgenda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "El sexo es: " + sexos[position], Toast.LENGTH_LONG).show();
                return true;
                // Con return true el long click “consume” el evento y solo se ejecuta tu Toast; con return false Android sigue propagándolo y, al soltar el dedo, además se dispara el click normal (onItemClick), así que salen dos Toast
            }
        });
    }
}