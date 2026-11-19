package com.example.menuaplicacion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
private ImageView imgView;
private ImageButton imgButton;

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

        imgView = findViewById(R.id.imgView);
        imgButton = findViewById(R.id.imgButton);

        imgButton.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = MainActivity.this.getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        if(item.getItemId()==R.id.item1) {

            Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();

        }
        if(item.getItemId()==R.id.item2) {
            Toast.makeText(getApplicationContext(), "Adios", Toast.LENGTH_LONG).show();
            intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.idealista.com/"));
            startActivity(intent);
        }

        if(item.getItemId()==R.id.subitem1) {

            Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();
            intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.fotocasa.es/es/"));
            startActivity(intent);
        }



        return true;
        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId()==R.id.rotar) {

            imgView.setRotation(90);
        }

        if(item.getItemId()==R.id.personalizado) {
            EditText input = new EditText(this);

            input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

            new AlertDialog.Builder(this)
                    .setTitle("Introduce un número")
                    .setView(input)
                    .setPositiveButton("Aceptar", (dialog, which) -> {
                        String texto = input.getText().toString().trim().replace(',', '.');
                        try {
                            float valor = Float.parseFloat(texto);
                            imgView.setRotation(valor);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Número no válido", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();

        }
        return false;
    }
}