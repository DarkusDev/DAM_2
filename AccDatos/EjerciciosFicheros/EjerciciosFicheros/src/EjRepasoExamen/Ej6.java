package EjRepasoExamen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ej6 {

    public static void main(String[] args) {

        try {
            DataOutputStream dOStream = new DataOutputStream(new FileOutputStream("./Vehiculos.dat", true));
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce la matricula del coche: ");
            String matricula = sc.nextLine();

            System.out.println("Introduce la marca del coche: ");
            String marca = sc.nextLine();

            System.out.println("Introduce el tamaño del deposito del coche: ");
            Double deposito = sc.nextDouble();
            sc.nextLine();

            System.out.println("Introduce la modelo del coche: ");
            String modelo = sc.nextLine();

            dOStream.writeUTF(matricula);
            dOStream.writeUTF(marca);
            dOStream.writeDouble(deposito);
            dOStream.writeUTF(modelo);

            leerArchivo();
        } catch (Exception e) {

        }

    }

    public static void leerArchivo() {

        try {
            DataInputStream dIStream = new DataInputStream(new FileInputStream("./Vehiculos.dat"));

            while (dIStream.available() > 0) {
                System.out.println("La matricula del coche es: " + dIStream.readUTF());
                System.out.println("La marca del coche es: " + dIStream.readUTF());
                System.out.println("El tamaño del deposito es: : " + dIStream.readDouble());
                System.out.println("El modelo del coche es: " + dIStream.readUTF());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
