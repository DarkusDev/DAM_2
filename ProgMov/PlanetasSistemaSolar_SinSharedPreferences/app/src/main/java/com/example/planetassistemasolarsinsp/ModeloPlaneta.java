package com.example.planetassistemasolarsinsp;

/**
 * Modelo de datos: un planeta con sus tres datos juntos.
 * Así, al ordenar la lista, el nombre, la distancia y el diámetro
 * se mueven a la vez y nunca se "descuadran" (cosa que sí pasaría
 * ordenando los tres arrays por separado).
 */
public class ModeloPlaneta {
    private String nombre;
    private long distancia;  // km al Sol
    private double diametro; // km

    public ModeloPlaneta() {
        this.nombre = "";
        this.distancia = 0;
        this.diametro = 0;
    }

    public ModeloPlaneta(String nombre, long distancia, double diametro) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.diametro = diametro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDistancia() {
        return distancia;
    }

    public void setDistancia(long distancia) {
        this.distancia = distancia;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
