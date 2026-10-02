package Ej29;
import java.io.Serializable;

public class Persona implements Serializable {

    private int edad;
    private String nombre;

    public Persona(String n, int e) {
        nombre = n;
        edad = e;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public String getName() {
        return nombre;
    }

    public void setEdad(int e) {
        edad = e;
    }

    public int getEdad() {
        return edad;
    }
}
