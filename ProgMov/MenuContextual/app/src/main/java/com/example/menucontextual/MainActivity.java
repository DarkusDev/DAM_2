package com.example.menucontextual;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ListView lvDatos;
    String[] personas = {"Pablo","Alvaro","Dani","Dumi","Mario","Pepe", "Ramiro", "Juan", "Ana", "Vega", "Hugo", "Gema", "Darius", "Karla", "Vlad", "Javi", "Leo", "Adrian", "Alina", "Antonio", "Rosa", "Manolo"};

    private ArrayList<String> listaPersonas = new ArrayList<>();
    private ArrayAdapter<String> adaptador;

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

        lvDatos = findViewById(R.id.lvDatos);

        Collections.addAll(listaPersonas, personas);

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPersonas);
        lvDatos.setAdapter(adaptador);

        lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_item_emergente, popupMenu.getMenu());

                Toast.makeText(MainActivity.this, "posicion: " + position, Toast.LENGTH_LONG).show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()== R.id.eliminar){
                            String eliminado = listaPersonas.remove(position);

                            Toast.makeText(MainActivity.this, "Eliminado:  " + eliminado, Toast.LENGTH_LONG).show();
                            adaptador.notifyDataSetChanged();
                        } else if (item.getItemId()== R.id.modificar) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("ModificarElemento");

                            EditText entrada = new EditText(MainActivity.this);
                            entrada.setText(listaPersonas.get(position).toString());

                            builder.setView(entrada);
                            builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String nuevoNombre = entrada.getText().toString();
                                    if(!nuevoNombre.isEmpty()){
                                        listaPersonas.set(position,nuevoNombre);

                                        Toast.makeText(MainActivity.this, "Modificado", Toast.LENGTH_LONG).show();
                                        adaptador.notifyDataSetChanged();
                                    }else{
                                        Toast.makeText(MainActivity.this, "Nombre no puede ser vacio", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                            builder.setNegativeButton("Descartar", null);

                            builder.show();
                        }


                        return false;
                    }
                });


                popupMenu.show();
            }
        });
    }
}