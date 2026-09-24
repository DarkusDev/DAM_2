import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CodificacionFicheros {
    public static void main(String[] args) {
        FileInputStream fichero;
        try {
            // Elegimos fichero para leer flujos de bytes "crudos"
            fichero = new FileInputStream("./Salida.txt");
            // InputStreamReader sirve de puente de flujos de byte a caracteres
            InputStreamReader unReader = new InputStreamReader(fichero);
            // Vemos la codificación actual
            System.out.println(unReader.getEncoding());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodificacionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}