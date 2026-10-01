package com.example.hotelcomidas;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox cbDesayuno;
    private CheckBox cbComida;
    private CheckBox cbCena;

    private TextView tvTotalPagar;

    private int totalPrecio = 0;
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


        cbDesayuno = findViewById(R.id.cbDesayuno);
        cbComida = findViewById(R.id.cbComida);
        cbCena = findViewById(R.id.cbCena);

        tvTotalPagar = findViewById(R.id.tvPagar);

        cbDesayuno.setOnCheckedChangeListener(this);
        cbComida.setOnCheckedChangeListener(this);
        cbCena.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
        if(buttonView.getId() == R.id.cbDesayuno){
            if(cbDesayuno.isChecked()){
                totalPrecio += 10;
                tvTotalPagar.setText("Total a pagar: " + totalPrecio + "€");
            }else{
                totalPrecio -= 10;
                tvTotalPagar.setText("Total a pagar: " + totalPrecio + "€");
            }

        }
        if(buttonView.getId() == R.id.cbComida){
            if(cbComida.isChecked()){
                totalPrecio += 25;
                tvTotalPagar.setText("Total a pagar: " + totalPrecio + "€");
            }else{
                totalPrecio -= 25;
                tvTotalPagar.setText("Total a pagar: " + totalPrecio + "€");
            }

        }
        if(buttonView.getId() == R.id.cbCena){
            if(cbCena.isChecked()){
                totalPrecio += 30;
                tvTotalPagar.setText("Total a pagar: " + totalPrecio + "€");
            }else{
                totalPrecio -= 30;
                tvTotalPagar.setText("Total a pagar: " + totalPrecio + "€");
            }

        }
    }

}