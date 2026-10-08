package com.example.banderas;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spPaises;
    private ImageView imgView;
    private TextView txtView;

    private int[] banderas = {0, R.drawable.espana, R.drawable.francia};
    private String[] nombres = {"Seleccione pais", "España", "Francia"};
    private String[] poblacion = {"Seleccione pais", "40.000.000", "80.000.000"};
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


        spPaises = findViewById(R.id.spPaises);
        imgView = findViewById(R.id.imgView);
        txtView = findViewById(R.id.txtView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, nombres);
        spPaises.setAdapter(arrayAdapter);

        spPaises.setSelection(0, false);

        spPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "posicion: " + position, Toast.LENGTH_LONG).show();
                imgView.setImageResource(banderas[position]);
                txtView.setText(poblacion[position]);

                imgView.setImageResource(banderas[position]);

                imgView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://es.wikipedia.org/wiki/Espa%C3%B1a"));
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}