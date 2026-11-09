import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LectorFichero extends Thread {

    private String nombre;
    private Monitor miMonitor;

    public LectorFichero(String nombre, Monitor miMonitor) {
        this.nombre = nombre;
        this.miMonitor = miMonitor;
    }

    @Override
    public void run() {
        File f = new File("./bin/" + nombre + ".txt");

        if (f.exists()) {
            try {
                BufferedReader bReader = new BufferedReader(new FileReader(f));
                int numero = Integer.parseInt(bReader.readLine());
                miMonitor.sumaColor(numero);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            miMonitor.sumaSinRespueta();
        }
    }
}
