import java.io.File;

public class Ej5 {
    public static void main(String[] args) {

        File dirInicial = new File(".");
        File d1 = new File("./d1");
        File f11 = new File("./d1/f11.txt");
        File d2 = new File("./d2");
        File f21 = new File("./d2/f21.txt");

        File nuevoNombre = new File(f11, "f12.txt");
        File nuevoDestino = new File(f11, "f21.txt");

        try {

            f11.renameTo(nuevoNombre);

            d2.delete();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        File[] contenido = dirInicial.listFiles();

        for (File f : contenido) {
            System.out.println(f);
        }
    }
}
