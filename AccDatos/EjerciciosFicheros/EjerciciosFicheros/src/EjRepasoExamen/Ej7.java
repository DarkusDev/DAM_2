package EjRepasoExamen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;

import java.util.Scanner;

public class Ej7 implements Serializable {

    public static void main(String[] args) {
        try {

            File f = new File("./VehiculosSerializables.dat");

            ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
            Scanner sc = new Scanner(System.in);

            if (f.exists() && f.length() > 0) {
                ObjectInputStream oIStream = new ObjectInputStream(new FileInputStream(f));
                listaVehiculos = (ArrayList<Vehiculo>) oIStream.readObject();
                oIStream.close();
            }
            System.out.println("Introduce la matricula del vehiculo");
            String matricula = sc.nextLine();

            System.out.println("Introduce la marca del vehiculo");
            String marca = sc.nextLine();

            System.out.println("Introduce el deposito del vehiculo");
            Double deposito = sc.nextDouble();
            sc.nextLine();

            System.out.println("Introduce el modelo del vehiculo");
            String modelo = sc.nextLine();

            Vehiculo vehiculoCreado = new Vehiculo(matricula, marca, deposito, modelo);

            listaVehiculos.add(vehiculoCreado);

            ObjectOutputStream oOStream = new ObjectOutputStream(new FileOutputStream("./VehiculosSerializables.dat"));

            oOStream.writeObject(listaVehiculos);

            for (Vehiculo elmento : listaVehiculos) {
                System.out.println();
                System.out.println("Matricula: " + elmento.getMatricula());
                System.out.println("Marca: " + elmento.getMarca());
                System.out.println("Deposito: " + elmento.getDeposito());
                System.out.println("Modelo: " + elmento.getModelo());
            }

            oOStream.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }

    }
}
