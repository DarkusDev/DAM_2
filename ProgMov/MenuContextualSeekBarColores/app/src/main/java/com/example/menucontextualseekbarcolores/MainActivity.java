package com.example.menucontextualseekbarcolores;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvClic;
    private LinearLayout llPrincipal;

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

        tvClic=(TextView) findViewById(R.id.tvClic);
        llPrincipal =(LinearLayout) findViewById(R.id.main);

        registerForContextMenu(tvClic);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Elija color de fondo");
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextual_colores, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //return super.onContextItemSelected(item);
        if(item.getItemId() == R.id.itemRojo){
            llPrincipal.setBackgroundColor(Color.rgb(255,0,0));
        } else if(item.getItemId() == R.id.itemVerde) {
            llPrincipal.setBackgroundColor(Color.rgb(0, 255, 0));
        }else if(item.getItemId() == R.id.itemAzul) {
            llPrincipal.setBackgroundColor(Color.rgb(0, 0, 255));
        }else if(item.getItemId() == R.id.itemColorPersonalizado) {
            cargarCuadroDialogoColores();
        }
        return true;
    }

    private void cargarCuadroDialogoColores() {
        View configuradorColores = View.inflate(MainActivity.this, R.layout.configurador_colores, null);

        TextView tvRojo = (TextView) configuradorColores.findViewById(R.id.tvRojo);
        TextView tvVerde = (TextView) configuradorColores.findViewById(R.id.tvVerde);
        TextView tvAzul = (TextView) configuradorColores.findViewById(R.id.tvAzul);
        SeekBar sbRojo = (SeekBar) configuradorColores.findViewById(R.id.sbRojo);
        SeekBar sbVerde = (SeekBar) configuradorColores.findViewById(R.id.sbVerde);
        SeekBar sbAzul = (SeekBar) configuradorColores.findViewById(R.id.sbAzul);

        sbRojo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvRojo.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbVerde.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvVerde.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbAzul.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAzul.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(configuradorColores);

        Button btnConfirmar=(Button) dialog.findViewById(R.id.btnConfirmar);
        Button btnDescartar=(Button) dialog.findViewById(R.id.btnDescartar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rojo = Integer.parseInt(tvRojo.getText().toString());
                int verde = Integer.parseInt(tvVerde.getText().toString());
                int azul = Integer.parseInt(tvAzul.getText().toString());

                llPrincipal.setBackgroundColor(Color.rgb(rojo, verde, azul));
                dialog.dismiss();

            }
        });

        btnDescartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "No se cambiará el color", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });


        dialog.show();
    }
}

    