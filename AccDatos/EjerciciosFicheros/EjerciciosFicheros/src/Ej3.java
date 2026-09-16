import java.io.File;

public class Ej3 {
    public static void main(String[] args) {
        File dirActual = new File(".");

        File[] contenido = dirActual.listFiles();

        String tipo = "";

        for (File f : contenido) {
            if(f.isDirectory()){
                tipo = "Directorio";
            } else{
                tipo = "Fichero";
            }

            System.out.println(f.getName() + " es " + tipo);
        }
    }
}
