import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej20 {
    public static void main(String[] args) throws IOException{
        EscribirFichero();
    }

    public static void EscribirFichero() throws IOException{
        try {
            DataOutputStream dStream = new DataOutputStream(new FileOutputStream("./fichero"));
            int[] enteros = { 1, 2, 3, 4, 5 };
            String[] strings = { "Hola", "Darius", "Adios" };

            for (int i = 0; i < enteros.length; i++) {
                dStream.writeByte(enteros[i]);
            }

            for (int i = 0; i < strings.length; i++) {
                dStream.writeBytes(strings[i]);
            }

            dStream.close();
            
            CopiarFicheroAOtroFichero();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void CopiarFicheroAOtroFichero() throws IOException{
        DataInputStream dInputStream = new DataInputStream(new FileInputStream("./fichero"));
        DataOutputStream dOutputStream = new DataOutputStream(new FileOutputStream("./ficheroCopia"));

        try {
            for(;;){
                dOutputStream.write(dInputStream.readAllBytes());
                break;
            }
            
        } catch (EOFException e) {
            dInputStream.close();
            dOutputStream.close();
            System.out.println("Fichero 1 copiado en fichero 2");
            
        }
    }
}
