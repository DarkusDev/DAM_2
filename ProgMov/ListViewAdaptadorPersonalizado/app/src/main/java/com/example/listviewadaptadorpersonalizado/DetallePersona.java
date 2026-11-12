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
        TextView tvAsigantura = findViewById(R.id.tvAsignatura);
        TextView tvNotaInd = findViewById(R.id.tvNotaIndividual);
        TextView tvNotaGrupo = findViewById(R.id.tvMediaGrupo);
        TextView tvMatematicas = findViewById(R.id.tvMatematicas);
        TextView tvProgramacion = findViewById(R.id.tvProgramacion);
        TextView tvBD = findViewById(R.id.tvBD);

        TextView tvNotaIndM = findViewById(R.id.tvNotaIndividualM);
        TextView tvNotaIndP = findViewById(R.id.tvNotaIndividualP);
        TextView tvNotaIndB = findViewById(R.id.tvNotaIndividualB);

        TextView tvMediaGrupM = findViewById(R.id.tvMediaGrupoM);
        TextView tvMediaGrupP = findViewById(R.id.tvMediaGrupoP);
        TextView tvMediaGrupB = findViewById(R.id.tvMediaGrupoB);

        TextView tvVariacionM = findViewById(R.id.tvVariacionM);
        TextView tvVariacionP = findViewById(R.id.tvVariacionP);
        TextView tvVariacionB = findViewById(R.id.tvVariacionB);
        Button btnVolver = findViewById(R.id.btnVolver);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tvNombre.setText(bundle.getString("nombre"));
            tvDescripcion.setText(bundle.getString("descripcion"));
            /*tvNotaIndM.setText(bundle.getInt("notaIndM"));
            tvNotaIndP.setText(bundle.getInt("notaIndP"));
            tvNotaIndB.setText(bundle.getInt("notaIndB"));

            tvMediaGrupM.setText(bundle.getInt("mediaM"));
            tvMediaGrupP.setText(bundle.getInt("mediaP"));
            tvMediaGrupB.setText(bundle.getInt("mediaB"));

            tvVariacionM.setText(bundle.getInt("variacionM"));
            tvVariacionP.setText(bundle.getInt("variacionP"));
            tvVariacionB.setText(bundle.getInt("variacionB"));*/ //No se porque cuando esto esta descomentado no carga el intent y salta una excepcion.
            imgvFoto.setImageResource(bundle.getInt("foto"));
        }

        btnVolver.setOnClickListener(v -> finish());
    }
}