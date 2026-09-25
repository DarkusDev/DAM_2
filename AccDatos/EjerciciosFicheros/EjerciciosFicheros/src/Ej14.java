import java.io.BufferedReader;
import java.io.FileReader;

public class Ej14 {

    public static void main(String[] args) {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader("./pruebaArrays.txt"));
            String linea = "";

            linea = bReader.readLine();
            String[] partes = linea.split("\\*");

            for (String parte : partes) {
                System.out.println(parte);
            }

            bReader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
