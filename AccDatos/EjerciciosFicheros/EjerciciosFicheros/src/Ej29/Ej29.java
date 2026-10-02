package Ej29;

import java.io.*;
import java.util.ArrayList;

public class Ej29 {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Darius", 19));
        listaPersonas.add(new Persona("Karla", 18));
        listaPersonas.add(new Persona("Vlad", 18));
        listaPersonas.add(new Persona("Pops", 17));

        
        try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream("./Personas.obj"))) {
            oOS.writeObject(listaPersonas); // se guarda la lista completa
        } catch (IOException e) {
            e.printStackTrace();
        }

        leerPersonas();
    }

    
    public static void leerPersonas() {
        try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream("./Personas.obj"))) {
            ArrayList<Persona> listaPersonas = (ArrayList<Persona>) oIS.readObject();
            for (Persona p : listaPersonas) {
                System.out.println(""+p.getName() + p.getEdad());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}