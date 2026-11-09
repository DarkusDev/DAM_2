import java.io.File;
import java.io.FileWriter;

public class Ecuestado {

    public static void main(String[] args) {
        int tiempoDormir = (int) (Math.random() * 501);

        int tiempoReflexion = (int) (Math.random() * 2001) + 1000;

        float probResponder = 0;

        try {
            Thread.sleep(tiempoDormir);

            String nombre = String.valueOf(System.currentTimeMillis());
            System.out.println(nombre);

            Thread.sleep(tiempoReflexion);

            probResponder = (float) Math.random() * 1;

            if (probResponder < 0.8) {
                int numGenerado = (int) (Math.random() * 9) + 1;
                FileWriter fWriter = new FileWriter(new File("./" + nombre + ".txt"));
                fWriter.write("" + numGenerado);

                fWriter.close();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
