import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hilo extends Thread {
    private Process proceso;
    private Monitor miMonitor = new Monitor();

    public Hilo(Process proceso, Monitor miMonitor) {
        this.proceso = proceso;
        this.miMonitor = miMonitor;
    }

    @Override
    public void run() {
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            miMonitor.escribeLista(bReader.readLine());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
