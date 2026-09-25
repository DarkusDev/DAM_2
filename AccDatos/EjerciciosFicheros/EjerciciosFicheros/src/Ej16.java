import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ej16 {
    public static void main(String[] args) {
        String[] cadena = new String[] { "Hola", "Darius", "Adios", "DAM" };
        String nombreArchivo = "./metodoCadenas.txt";

        EscribeArchivo(cadena, nombreArchivo);
    }

    public static void EscribeArchivo(String[] cadena, String archivo) {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(archivo));
            
            for (int i = 0; i < cadena.length; i++){
                bWriter.write(cadena[i]);
                bWriter.newLine();
            }

            bWriter.close();

            EscribePantalla(archivo);
            
        } catch (Exception e) {
           
        }
    }

    public static void EscribePantalla(String archivo){
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(archivo));
            String linea = "";

            while((linea = bReader.readLine()) != null){
                System.out.println(linea);
            }

            bReader.close();
        } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
        }
    }
}
