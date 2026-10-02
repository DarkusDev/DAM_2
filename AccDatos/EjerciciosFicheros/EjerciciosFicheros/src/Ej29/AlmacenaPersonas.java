package Ej29;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;

public class AlmacenaPersonas {
    public static Scanner sc = new Scanner(System.in);
    public static boolean menuActivo = true;
    public static int opcionMenu;

    public static String nombre = "";
    public static int edad = 0;

    public static void main(String[] args) {

        while (menuActivo) {
            CargaMenu();
        }
    }

    public static void CargaMenu() {
        try {

            System.out.println("1. Registrar persona ");
            System.out.println("2. Consultar persona ");
            System.out.println("3. Salir ");

            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1:

                    sc.next();
                RegistrarPersona();

                    

                case 2:

                    ConsultarPersona();

                    

                case 3:

                    menuActivo = false;

                    break;

                default:
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Introduce un numero, prueba de nuevo: ");
            sc.next();

        }
    }

    public static void RegistrarPersona() {
        
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        String entrada = "";
        int i = 0;

        try {
            ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream("./Personas.obj"));
            while (!entrada.equalsIgnoreCase("salir")) {
                System.out.println("Nombre: ");
                entrada = sc.nextLine();
                nombre = entrada;
                

                System.out.println("Edad: ");
                entrada = sc.nextLine();
                edad = Integer.parseInt(entrada);
                

                listaPersonas.add(new Persona(nombre, edad));
                i++;
            }

            for (Persona persona : listaPersonas) {
                oOS.writeObject(persona);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void ConsultarPersona() {
        System.out.println("Consultar");
    }
}
