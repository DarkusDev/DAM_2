import java.io.File;

public class Ej8 {

    public static void main(String[] args) {
        File dirIncial = new File(".");

        File usr1 = new File(dirIncial, "usr1");

        File f1 = new File(usr1, "f1.txt");

        File usr2 = new File(dirIncial, "usr2");

        File d1 = new File(usr2, "d1");
        File f2 = new File(d1, "f2.txt");

        File d2 = new File(usr2, "d2");
        File f3 = new File(d2, "f3.txt");
        File f4 = new File(d2, "f4.txt");

        File d3 = new File(usr2, "d3");

          try {

            usr1.mkdir();
            f1.createNewFile();
            usr2.mkdir();
            d1.mkdir();
            f2.createNewFile();
            d2.mkdir();
            f3.createNewFile();
            f4.createNewFile();
            d3.mkdir();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        File[] contenido = dirIncial.listFiles();

        for (File f : contenido) {
            System.out.println(f);
        }
    }
}
