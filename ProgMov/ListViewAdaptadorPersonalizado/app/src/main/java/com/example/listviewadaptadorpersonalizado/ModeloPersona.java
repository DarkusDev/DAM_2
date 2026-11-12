package com.example.listviewadaptadorpersonalizado;

import java.util.HashMap;
import java.util.Map;

public class ModeloPersona {
    private Map<String, Double> notas = new HashMap<>();
    private String nombre;
    private String DNI;
    private double notaMedia;
    private int foto;


    public ModeloPersona(){
        this.notas = null;
        this.nombre = "";
        this.DNI = "";
        this.foto = 0;
    }
    public ModeloPersona(String nombre, String descripcion, int foto, Map<String,Double> notas) {
        this.notas = notas;
        this.nombre = nombre;
        this.DNI = descripcion;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public double getNotaMedia() {
        Double notaMates = notas.get("Matemáticas");
        Double notaProg = notas.get("Programación");
        Double notaBD = notas.get("Bases de Datos");

        notaMedia = (notaMates + notaProg + notaBD) / 3;
        return notaMedia;
    }

    public void setNotaMedia(int notaMedia) {
        this.notaMedia = notaMedia;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public String toString(){
        return nombre + " - " + DNI;
    }
}
