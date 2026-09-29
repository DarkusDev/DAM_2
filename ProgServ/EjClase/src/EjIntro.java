import java.io.File;

public class EjIntro {
    public static void main(String[] args) {
        String[] sArgs = new String[2];
        sArgs[0] = "/usr/bin/java";
        sArgs[1] = "EjIntroPrueba"; // Lanzar procesos con array de entrada

        ProcessBuilder pBuilder = new ProcessBuilder(sArgs);

        // ProcessBuilder pBuilder = new
        // ProcessBuilder("/usr/bin/java","EjIntroPrueba"); //Lanzar proceso con
        // secuencia de strings
        Process process = null;
        pBuilder.directory(new File("./bin"));

        try {
            process = pBuilder.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(process.pid());
    }
}
