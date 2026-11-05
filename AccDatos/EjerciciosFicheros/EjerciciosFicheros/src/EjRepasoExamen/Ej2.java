package EjRepasoExamen;

import java.io.File;

public class Ej2 {

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
                System.out.println(sangria + f.getName());
                System.out.println(sangria + f.canRead());
                System.out.println(sangria + f.canWrite());
                System.out.println(sangria + f.length());
                System.out.println(sangria + f.getAbsolutePath());
            }
        }
    }

}
