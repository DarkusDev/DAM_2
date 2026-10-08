package com.example.toggle_switchbutton;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private Switch sw;

    private TextView tv1;
    private TextView tv2;


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

        toggleButton = findViewById(R.id.tgButton);
        sw = findViewById(R.id.switch1);
        tv1 = findViewById(R.id.txtActivar1);
        tv2 = findViewById(R.id.txtActivar2);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv2.setText(getResources().getText(R.string.desactivar));
                    tv2.setTextColor(getResources().getColor(R.color.rojo));
                }

                if(!isChecked){
                    tv2.setText(getResources().getText(R.string.activar));
                    tv2.setTextColor(getResources().getColor(R.color.gris));
                }

            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv1.setText(getResources().getText(R.string.desactivar));
                    tv1.setTextColor(getResources().getColor(R.color.rojo));
                }

                if(!isChecked){
                    tv1.setText(getResources().getText(R.string.activar));
                    tv1.setTextColor(getResources().getColor(R.color.gris));
                }
            }
        });
    }


}