package com.example.planetassistemasolar;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla de bienvenida (Splash Screen). Es la actividad LAUNCHER del Manifest.
 * Un hilo (Thread) espera unos segundos y después abre MainActivity.
 */
public class SplashActivity extends AppCompatActivity {

    private static final int DURACION_SPLASH = 3000; // milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // Creamos un hilo aparte para no bloquear la pantalla mientras esperamos
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(DURACION_SPLASH); // el hilo "duerme" 3 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Pase lo que pase, al terminar vamos a la actividad principal
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish(); // cerramos el splash para que "atrás" no vuelva a él
                }
            }
        };
        hilo.start();
    }
}
