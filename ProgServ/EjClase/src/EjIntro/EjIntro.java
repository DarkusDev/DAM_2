package EjIntro;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class EjIntro {
    public static void main(String[] args) {
        String[] sArgs = new String[2];
        sArgs[0] = "/usr/java/jdk-24.0.2/bin/java";
        sArgs[1] = "EjIntroPrueba"; 

        //ProcessBuilder pBuilder = new ProcessBuilder(sArgs); // Lanzar procesos con array de entrada

        ProcessBuilder pBuilder = new ProcessBuilder("/usr/java/jdk-24.0.2/bin/java","EjIntroPrueba"); //Lanzar proceso con secuencia de strings
        
        //ProcessBuilder pBuilder = new ProcessBuilder("firefox"); // Lanzar apps
        Process process = null;
        pBuilder.directory(new File("./bin")); //Usar el metodo directory para establecer el directorio donde se cran los archivos

        try {
            process = pBuilder.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(process.pid());
        
        InputStream iStream = process.getInputStream();
        InputStreamReader iSReader = new InputStreamReader(iStream);
        BufferedReader bReader = new BufferedReader(iSReader);
        String info = "";
        
        int iSalida = 111;
        boolean bSalida = false;
        
        try {
        	/*while((info = bReader.readLine()) != null) {
        		System.out.println(info);
        	}*/
        	
        	//iSalida = process.waitFor();
        	//bSalida = process.waitFor(1, TimeUnit.SECONDS);
        	if(process.isAlive()) {
        		System.out.println("El proceso hijo esta activo");
        	}else {
        		System.out.println("El proceso hijo no esta activo");
        	}
        }catch(Exception e) {
        	System.out.println("Error: " + e.getMessage());
        }
        
        
        
        if(bSalida) {
        	iSalida = process.exitValue();
        }
        
        System.out.println("Salida de int: " + iSalida);
        System.out.println("Salida de bool: " + bSalida);
    }
}
