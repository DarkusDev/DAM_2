import java.io.BufferedWriter;
import java.io.FileWriter;

public class Ej13 {

    public static void main(String[] args) {
        String[] cadenas = new String[] { "Hola", "Darius", "Adios", "DAM" };

        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter("./pruebaArrays.txt"));

            bWriter.write(String.join("*", cadenas));

            bWriter.close();
        } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
        }

    }
}
