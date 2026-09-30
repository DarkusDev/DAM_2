package com.example.calculadoraprogramatica3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etOperando1;
    private EditText etOperando2;
    private TextView tvResultado;

    private RadioButton rbSumar;
    private RadioButton rbRestar;
    private RadioButton rbMultiplicar;
    private RadioButton rbDividir;

    private Double operando1, operando2, resultado;

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

        rbSumar = findViewById(R.id.rbSumar);
        rbRestar = findViewById(R.id.rbRestar);
        rbMultiplicar = findViewById(R.id.rbMultiplicar);
        rbDividir = findViewById(R.id.rbDividir);

        rbSumar.setOnClickListener(this);
        rbRestar.setOnClickListener(this);
        rbDividir.setOnClickListener(this);
        rbMultiplicar.setOnClickListener(this);
    }

    public void sumar(Double operando1, Double operando2) {



        resultado = operando1 + operando2;

        tvResultado.setText(resultado.toString());

    }

    public void restar(Double operando1, Double operando2) {


        resultado = operando1 - operando2;
        tvResultado.setText(resultado.toString());
    }

    public void multiplicar(Double operando1, Double operando2) {


        resultado = operando1 * operando2;
        tvResultado.setText(resultado.toString());
    }

    public void dividir(Double operando1, Double operando2) {
        try {

            if (operando2 == 0){
                throw new ArithmeticException();
            }
            resultado = operando1 / operando2;
            tvResultado.setText(resultado.toString());
        }catch (ArithmeticException ae){
            Toast.makeText(getApplicationContext(), "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        try{
            operando1 = Double.parseDouble(etOperando1.getText().toString());
            operando2 = Double.parseDouble(etOperando2.getText().toString());

            if(v.getId() == R.id.rbSumar){
                sumar(operando1, operando2);
            }
            if (v.getId() == R.id.rbRestar) {
                restar(operando1, operando2);
            }
            if (v.getId() == R.id.rbDividir) {
                dividir(operando1, operando2);
            }
            if (v.getId() == R.id.rbMultiplicar) {
                multiplicar(operando1, operando2);
            }
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Falta operando", Toast.LENGTH_SHORT).show();
        }


    }
}