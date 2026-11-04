package com.example.orientacionlayoutbloqueo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnHorizontal;
    private Button btnVertical;
    private Button btnAuto;

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
        btnHorizontal = (Button) findViewById(R.id.btnHorizontal);
        btnVertical = (Button) findViewById(R.id.btnVertical);
        btnAuto = (Button) findViewById(R.id.btnAuto);

        btnHorizontal.setOnClickListener(this);
        btnVertical.setOnClickListener(this);
        btnAuto.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHorizontal) {
            Toast.makeText(getApplicationContext(), "Orientación Horizontal", Toast.LENGTH_LONG).show();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        if (v.getId() == R.id.btnVertical) {
            Toast.makeText(getApplicationContext(), "Orientación Vertical", Toast.LENGTH_LONG).show();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        if (v.getId() == R.id.btnAuto) {
            Toast.makeText(getApplicationContext(), "Orientación Automática", Toast.LENGTH_LONG).show();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        }
    }
}