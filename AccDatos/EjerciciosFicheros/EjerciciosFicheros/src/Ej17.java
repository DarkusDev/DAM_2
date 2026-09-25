import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Ej17 {
    public static void main(String[] args) {
        String archivo = "./metodoCadenas.txt";
        LeerArchivo(archivo);
    }

    public static void LeerArchivo(String archivo){
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(archivo));
            String linea = "";

            ArrayList<String> contenido  = new ArrayList<String>();
            

            while((linea = bReader.readLine()) != null){
                contenido.add(linea);
            }
            contenido.sort(null);

            bReader.close();
            EscribirOrdenado(archivo, contenido);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void EscribirOrdenado(String archivo, ArrayList<String> contenido){
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(archivo));

            for (int i = 0; i < contenido.size(); i++){
                bWriter.write(contenido.get(i));
                bWriter.newLine();
            }

            bWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
