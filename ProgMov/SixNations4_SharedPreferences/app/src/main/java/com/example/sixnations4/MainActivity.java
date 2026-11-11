package com.example.sixnations4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    // Arrays "paralelos" (como en 07SpinnerPaises): la posición 0 es "sin elegir",
    // y la misma posición en los dos arrays corresponde al mismo país.
    // Son public static para poder usarlos también desde el adaptador y el modelo.
    public static final String[] PAISES = {"Elija nacionalidad", "Inglaterra", "Escocia", "Gales", "Irlanda", "Francia", "Italia"};
    public static final int[] BANDERAS = {R.drawable.bandera_generica, R.drawable.inglaterra, R.drawable.escocia,
            R.drawable.gales, R.drawable.irlanda, R.drawable.francia, R.drawable.italia};

    // Nombre del fichero de SharedPreferences y claves que usamos dentro
    private static final String FICHERO_PREFERENCIAS = "datos_sixnations";
    private static final String CLAVE_NUM_JUGADORES = "numJugadores";

    private ListView lvJugadores;
    private ImageButton btnAgregar;

    private ArrayList<ModeloJugador> jugadores;
    private AdaptadorJugador adaptador;
    private int contadorOrden = 0; // cada jugador nuevo recibe el siguiente número

    private SharedPreferences preferencias;

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

        lvJugadores = (ListView) findViewById(R.id.lvJugadores);
        btnAgregar = (ImageButton) findViewById(R.id.btnAgregar);

        // Abrimos (o se crea si no existe) el fichero de preferencias privado de la app
        preferencias = getSharedPreferences(FICHERO_PREFERENCIAS, Context.MODE_PRIVATE);

        // Lista de datos + recuperación de lo guardado la última vez
        jugadores = new ArrayList<ModeloJugador>();
        cargarDatos();

        // Adaptador personalizado (como en ListViewAdaptadorPersonalizado)
        adaptador = new AdaptadorJugador(this, jugadores);
        lvJugadores.setAdapter(adaptador);

        // Menú emergente (contextual) al mantener pulsado un ítem del ListView
        registerForContextMenu(lvJugadores);

        // Botón "+" -> diálogo en modo "Agregar" (posición -1 = jugador nuevo)
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoJugador(-1);
            }
        });
    }

    // ===================== MENÚ DE APLICACIÓN (barra superior) =====================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = MainActivity.this.getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemOrdenarPuntos) {
            ordenarPorPuntuacion(jugadores);
            adaptador.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Ordenados por puntuación", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.itemOrdenInsercion) {
            ordenarPorInsercion(jugadores);
            adaptador.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Orden de inserción", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    // ===================== MENÚ CONTEXTUAL (sobre cada ítem) =====================

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        // El menuInfo nos dice sobre qué fila del ListView se abrió el menú
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int posicion = info.position;

        if (item.getItemId() == R.id.itemEliminar) {
            confirmarEliminar(posicion);
            return true;
        }
        if (item.getItemId() == R.id.itemActualizar) {
            mostrarDialogoJugador(posicion);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    // ===================== DIÁLOGOS =====================

    /**
     * Muestra el AlertDialog con el formulario del jugador.
     * posicion == -1  -> "Agregar Jugador" (formulario vacío)
     * posicion >= 0   -> "Actualizar Jugador" (formulario relleno con ese jugador)
     */
    private void mostrarDialogoJugador(int posicion) {
        // Inflamos el diseño del diálogo (res/layout/dialogo_jugador.xml)
        View vista = getLayoutInflater().inflate(R.layout.dialogo_jugador, null);

        // Los elementos se buscan DENTRO de la vista del diálogo
        TextView tvTitulo = vista.findViewById(R.id.tvTituloDialogo);
        EditText etNombre = vista.findViewById(R.id.etNombre);
        Spinner spNacionalidad = vista.findViewById(R.id.spNacionalidad);
        EditText etValoracion = vista.findViewById(R.id.etValoracion);
        ImageView imgvBandera = vista.findViewById(R.id.imgvBanderaDialogo);
        Button btnCancelar = vista.findViewById(R.id.btnCancelar);
        Button btnGuardar = vista.findViewById(R.id.btnGuardar);

        // Spinner con las nacionalidades
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, PAISES);
        spNacionalidad.setAdapter(arrayAdapter);

        // Al elegir país, cambia la imagen a su bandera (posición 0 = imagen genérica)
        spNacionalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imgvBandera.setImageResource(BANDERAS[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        if (posicion == -1) {
            tvTitulo.setText("Agregar Jugador");
            imgvBandera.setImageResource(BANDERAS[0]);
        } else {
            // Rellenamos el formulario con los datos actuales del jugador
            ModeloJugador jugador = jugadores.get(posicion);
            tvTitulo.setText("Actualizar Jugador");
            etNombre.setText(jugador.getNombre());
            spNacionalidad.setSelection(jugador.getPais());
            etValoracion.setText(String.valueOf(jugador.getPuntos()));
            imgvBandera.setImageResource(BANDERAS[jugador.getPais()]);
        }

        // Creamos el AlertDialog con nuestro diseño
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(vista);
        AlertDialog dialogo = builder.create();

        // Cancelar: cerramos sin hacer nada
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.dismiss();
            }
        });

        // Guardar: validamos; si algo falla -> Toast y el diálogo SIGUE abierto
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString().trim();
                int pais = spNacionalidad.getSelectedItemPosition();
                String textoValoracion = etValoracion.getText().toString().trim();

                if (nombre.isEmpty() || pais == 0 || textoValoracion.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe rellenar el nombre, elegir nacionalidad e insertar la valoración", Toast.LENGTH_LONG).show();
                    return;
                }

                int puntos;
                try {
                    puntos = Integer.parseInt(textoValoracion);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "La valoración debe ser un número", Toast.LENGTH_LONG).show();
                    return;
                }
                if (puntos < 0 || puntos > 10) {
                    Toast.makeText(getApplicationContext(), "La valoración debe estar entre 0 y 10", Toast.LENGTH_LONG).show();
                    return;
                }

                if (posicion == -1) {
                    // Nuevo jugador al final de la lista
                    contadorOrden++;
                    jugadores.add(new ModeloJugador(nombre, pais, puntos, contadorOrden));
                } else {
                    // Modificamos el jugador existente (mantiene su orden de inserción)
                    ModeloJugador jugador = jugadores.get(posicion);
                    jugador.setNombre(nombre);
                    jugador.setPais(pais);
                    jugador.setPuntos(puntos);
                }

                adaptador.notifyDataSetChanged(); // refresca el ListView
                guardarDatos();                   // persistimos el cambio
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }

    /** Diálogo de confirmación antes de borrar un registro. */
    private void confirmarEliminar(int posicion) {
        ModeloJugador jugador = jugadores.get(posicion);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Eliminar Registro");
        builder.setMessage("¿Seguro que desea eliminar el registro: \"" + jugador.getNombre() + "\"?");
        builder.setNegativeButton("Cancelar", null); // null = solo cierra el diálogo
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                jugadores.remove(posicion);
                adaptador.notifyDataSetChanged();
                guardarDatos();
                Toast.makeText(getApplicationContext(), "Registro eliminado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    // ===================== ORDENACIÓN =====================

    private void ordenarPorPuntuacion(ArrayList<ModeloJugador> lista) {
        // De mayor a menor puntuación. Collections.sort es "estable":
        // con los mismos puntos se respeta el orden en que ya estaban.
        Collections.sort(lista, new Comparator<ModeloJugador>() {
            @Override
            public int compare(ModeloJugador j1, ModeloJugador j2) {
                return j2.getPuntos() - j1.getPuntos();
            }
        });
    }

    private void ordenarPorInsercion(ArrayList<ModeloJugador> lista) {
        Collections.sort(lista, new Comparator<ModeloJugador>() {
            @Override
            public int compare(ModeloJugador j1, ModeloJugador j2) {
                return j1.getOrden() - j2.getOrden();
            }
        });
    }

    // ===================== PERSISTENCIA (SharedPreferences) =====================

    /**
     * Guarda todos los jugadores en SharedPreferences, SIEMPRE en orden de inserción
     * (aunque en pantalla estén ordenados por puntos). Formato clave-valor:
     *   numJugadores = 3
     *   nombre_0 = "John Collins", pais_0 = 1, puntos_0 = 8
     *   nombre_1 = ...
     */
    private void guardarDatos() {
        ArrayList<ModeloJugador> copia = new ArrayList<>(jugadores);
        ordenarPorInsercion(copia);

        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear(); // borramos lo anterior (por si ahora hay menos jugadores)
        editor.putInt(CLAVE_NUM_JUGADORES, copia.size());
        for (int i = 0; i < copia.size(); i++) {
            ModeloJugador jugador = copia.get(i);
            editor.putString("nombre_" + i, jugador.getNombre());
            editor.putInt("pais_" + i, jugador.getPais());
            editor.putInt("puntos_" + i, jugador.getPuntos());
        }
        editor.apply(); // guarda en segundo plano
    }

    /** Lee los jugadores guardados y los añade a la lista en el mismo orden. */
    private void cargarDatos() {
        int numJugadores = preferencias.getInt(CLAVE_NUM_JUGADORES, 0); // 0 si es la primera vez
        for (int i = 0; i < numJugadores; i++) {
            String nombre = preferencias.getString("nombre_" + i, "");
            int pais = preferencias.getInt("pais_" + i, 0);
            int puntos = preferencias.getInt("puntos_" + i, 0);
            contadorOrden++;
            jugadores.add(new ModeloJugador(nombre, pais, puntos, contadorOrden));
        }
    }
}
