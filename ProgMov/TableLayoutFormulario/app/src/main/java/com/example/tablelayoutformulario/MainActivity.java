package com.example.tablelayoutformulario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText etCodigo, etNombre, etPrecio;
    private Button btnLimpiar, btnGuardar;
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
        etCodigo = findViewById(R.id.etCodigo);
        etNombre = findViewById(R.id.etNombre);
        etPrecio = findViewById(R.id.etPrecio);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Evento para el botón Guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarProducto();
            }
        });

        // Evento para el botón Limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarFormulario();
            }
        });
    }

    private void limpiarFormulario() {
        etNombre.setText("");
        etPrecio.setText("");
        etCodigo.requestFocus(); // Devuelve el foco al primer campo
    }
    private void limpiarFormulario2() {
        etNombre.setText("");
        etPrecio.setText("");
        etCodigo.requestFocus(); // Devuelve el foco al primer campo
    }

    private void guardarProducto() {
        String codigo = etCodigo.getText().toString().trim();
        String nombre = etNombre.getText().toString().trim();
        String precio = etPrecio.getText().toString().trim();

        // Validación simple de campos vacíos
        if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty())
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        else {
            String mensaje = "Producto registrado: " + nombre + " (" + precio + "€)";
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
            limpiarFormulario2();
        }
    }
}