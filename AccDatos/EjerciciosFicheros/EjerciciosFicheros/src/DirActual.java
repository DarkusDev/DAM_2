import java.io.File;

public class DirActual {
    public static void main(String[] args) {
        File dir = new File(".");

        try {
            System.out.println(dir.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }


    }
}
