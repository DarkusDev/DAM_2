import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
    	System.out.println(new File(".").getAbsolutePath());
        Scanner sc = new Scanner(System.in);
        int numEncuestados = 0;
        try {
            System.out.println("Indica el numero de encuestados que participan: ");
            numEncuestados = Integer.parseInt(sc.nextLine());

            if (numEncuestados <= 0) {
                numEncuestados = 5;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            numEncuestados = 5;
        }

        ProcessBuilder pBuilder = null;
        Process[] procesos = new Process[numEncuestados];
        ArrayList<Hilo> hilos = new ArrayList<>();
        Monitor miMonitor = new Monitor();

        
        try {
            for (int i = 0; i < procesos.length; i++) {

                pBuilder = new ProcessBuilder("/usr/java/jdk-24.0.2/bin/java", "Ecuestado");
                pBuilder.directory(new File("./bin"));
                procesos[i] = pBuilder.start();

            }

            for (Process process : procesos) {
                Hilo h = new Hilo(process, miMonitor);
                hilos.add(h);
                h.start();

            }

            for (Hilo h : hilos) {
                h.join();
            }

            for (Process process : procesos) {
                process.waitFor();
            }

            Thread.sleep(1000);

            ArrayList<LectorFichero> hilosLectores = new ArrayList<>();

            for (String nombre : miMonitor.getLista()) {
                LectorFichero hiloLector = new LectorFichero(nombre, miMonitor);
                hiloLector.start();
                hilosLectores.add(hiloLector);
            }

            for (LectorFichero l : hilosLectores) {
                l.join();
            }

            mostrarResultados(miMonitor, numEncuestados);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void mostrarResultados(Monitor miMonitor, int numEncuestados) {
        String[] colores = { "", "Blanco", "Azul", "Verde", "Rojo", "Amarillo", "Naranja", "Marrón", "Gris", "Negro" };

        for (int i = 1; i < 10; i++) {
            System.out.println("Color: " + colores[i] + " votos: " + miMonitor.getContadores()[i]);
        }

        System.out.println("Total encuestados: " + numEncuestados);
        System.out.println("No respondidos: " + miMonitor.getNoRespondidos());
    }
}
