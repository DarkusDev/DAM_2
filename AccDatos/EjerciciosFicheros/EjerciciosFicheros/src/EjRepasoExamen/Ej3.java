package EjRepasoExamen;

import java.io.File;

public class Ej3 {

    public static void main(String[] args) {

        File directorio = new File(".");
        Listar(directorio, "   ");
    }

    public static void Listar(File dir, String sangria) {
        File[] contenido = dir.listFiles();
        if (contenido == null) {
            return;
        }

        for (File f : contenido) {
            if (f.isDirectory()) {
                System.out.println(" DIR " + f.getName());
                Listar(f, sangria);
            } else {
                if (f.getAbsolutePath().contains(".txt")) {
                    System.out.println(sangria + f.getName());
                    System.out.println(sangria + f.getAbsolutePath());
                }

            }
        }
    }
}
