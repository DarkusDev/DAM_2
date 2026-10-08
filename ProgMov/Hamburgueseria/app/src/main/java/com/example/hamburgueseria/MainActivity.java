package com.example.hamburgueseria;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbTernera;
    private RadioButton rbPollo;
    private RadioButton rbPescado;

    private ImageView imFoto;

    private CheckBox cbPepinillos;
    private CheckBox cbQueso;
    private CheckBox cbBacon;

    private Switch swDescuento;
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

        rbTernera = findViewById(R.id.rbTernera);
        rbPollo = findViewById(R.id.rbPollo);
        rbPescado = findViewById(R.id.rbPescado);

        imFoto = findViewById(R.id.ivFoto);

        cbPepinillos = findViewById(R.id.cbPepinillos);
        cbQueso = findViewById(R.id.cbQueso);
        cbBacon = findViewById(R.id.cbBacon);

        swDescuento = findViewById(R.id.swDescuento);


    }
}