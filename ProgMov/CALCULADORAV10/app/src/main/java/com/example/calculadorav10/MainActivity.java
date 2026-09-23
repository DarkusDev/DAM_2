package com.example.calculadorav10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etOperando1;
    private EditText etOperando2;
    private TextView tvResultado;

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

        etOperando1 = findViewById(R.id.etOperando1);
        etOperando2 = findViewById(R.id.etOperando2);
        tvResultado = findViewById(R.id.tvResultado);

        Button btnSumar = findViewById(R.id.btnSumar);
        Button btnRestar = findViewById(R.id.btnRestar);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
        Button btnDividir = findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(v -> sumar());
        btnRestar.setOnClickListener(v -> restar());
        btnMultiplicar.setOnClickListener(v -> multiplicar());
        btnDividir.setOnClickListener(v -> dividir());
    }

    private void sumar() {
        Double[] operandos = leerOperandos();
        if (operandos == null) {
            return;
        }
        mostrarResultado(operandos[0] + operandos[1]);
    }

    private void restar() {
        Double[] operandos = leerOperandos();
        if (operandos == null) {
            return;
        }
        mostrarResultado(operandos[0] - operandos[1]);
    }

    private void multiplicar() {
        Double[] operandos = leerOperandos();
        if (operandos == null) {
            return;
        }
        mostrarResultado(operandos[0] * operandos[1]);
    }

    private void dividir() {
        Double[] operandos = leerOperandos();
        if (operandos == null) {
            return;
        }
        if (operandos[1] == 0) {
            mostrarError(R.string.error_division_cero);
            return;
        }
        mostrarResultado(operandos[0] / operandos[1]);
    }

    /**
     * Devuelve los dos operandos, o null (avisando al usuario) si alguno no es un número válido.
     */
    private Double[] leerOperandos() {
        Double operando1 = leerOperando(etOperando1);
        Double operando2 = leerOperando(etOperando2);
        if (operando1 == null || operando2 == null) {
            mostrarError(R.string.error_operandos);
            return null;
        }
        return new Double[]{operando1, operando2};
    }

    private Double leerOperando(EditText campo) {
        // El teclado decimal usa la coma en español, pero parseDouble espera un punto.
        String texto = campo.getText().toString().trim().replace(',', '.');
        if (texto.isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void mostrarResultado(double resultado) {
        // Sin decimales cuando el resultado es exacto: 4 en vez de 4.0
        if (resultado == Math.rint(resultado) && !Double.isInfinite(resultado)) {
            tvResultado.setText(String.valueOf((long) resultado));
        } else {
            tvResultado.setText(String.valueOf(resultado));
        }
    }

    private void mostrarError(@StringRes int mensaje) {
        tvResultado.setText(R.string.resultado_vacio);
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
