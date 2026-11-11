package com.example.sixnations4;

/**
 * Modelo de datos: un jugador de la lista (igual que ModeloPersona).
 * El país NO se guarda como texto ni como imagen, sino como la POSICIÓN
 * dentro de MainActivity.PAISES / MainActivity.BANDERAS. Así, con un solo
 * número sabemos el nombre del país y su bandera.
 */
public class ModeloJugador {
    private String nombre;
    private int pais;    // posición en el array PAISES (1 = Inglaterra, 2 = Escocia...)
    private int puntos;  // valoración de 0 a 10
    private int orden;   // nº de inserción, para poder volver al orden original

    public ModeloJugador() {
        this.nombre = "";
        this.pais = 0;
        this.puntos = 0;
        this.orden = 0;
    }

    public ModeloJugador(String nombre, int pais, int puntos, int orden) {
        this.nombre = nombre;
        this.pais = pais;
        this.puntos = puntos;
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return nombre + " - " + MainActivity.PAISES[pais] + " - " + puntos + " puntos";
    }
}
