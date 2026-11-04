package com.example.listviewadaptadorpersonalizado;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetallePersona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_persona);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imgvFoto = findViewById(R.id.imgvFotoDetalle);
        TextView tvNombre = findViewById(R.id.tvNombreDetalle);
        TextView tvDescripcion = findViewById(R.id.tvDescripcionDetalle);
        TextView tvCodigo = findViewById(R.id.tvCodigoDetalle);
        Button btnVolver = findViewById(R.id.btnVolver);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tvNombre.setText(bundle.getString("nombre"));
            tvDescripcion.setText(bundle.getString("descripcion"));
            tvCodigo.setText("Código: " + bundle.getInt("codigo"));
            imgvFoto.setImageResource(bundle.getInt("foto"));
        }

        btnVolver.setOnClickListener(v -> finish());
    }
}