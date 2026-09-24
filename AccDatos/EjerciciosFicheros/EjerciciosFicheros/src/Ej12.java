import java.io.BufferedReader;
import java.io.FileReader;

public class Ej12 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./numNaturales.txt"));
            int suma = 0;
            String linea = "";
            while ((linea = br.readLine()) != null) {
                linea.trim();
                if (!linea.isEmpty()) {
                    suma += Integer.parseInt(linea);
                }

            }

            System.out.println("La suma total es: " + suma);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
