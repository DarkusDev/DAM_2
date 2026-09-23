
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tema1Prueba {
	public static void main (String [] args)
	{
		String [] sArg = new String [2];
		sArg[0] = "/usr/java/jdk-24.0.2/bin/java";	// Consultar localizacion con which java
		sArg[1] = "Tema1PruebaH";					// .class, sin indicar
		ProcessBuilder mipb = null;
		Process miProc = null;
		mipb = new ProcessBuilder("python3", "prueba.py");
		// mipb = new ProcessBuilder("/usr/java/jdk-20.0.2/bin/java","Tema1PruebaH");
		// mipb = new ProcessBuilder("python3","prueba.py");
		// mipb = new ProcessBuilder("ls","-la");
		// mipb = new ProcessBuilder("/usr/java/jdk-20.0.2/bin/java","Tema1PruebaHe");
		// mipb = new ProcessBuilder("firefox");
		mipb.directory(new File("./bin"));
		
		try {
			miProc = mipb.start();	// Inicia el proceso
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(miProc.pid());	// Pid del proceso iniciado

		// Enlazar salida estandar del proceso hijo con este proceso padre
		InputStream miIs = miProc.getInputStream();
		InputStreamReader miIsr = new InputStreamReader(miIs);
		BufferedReader miIsrb = new BufferedReader(miIsr);
		String sInfo = "";
		try {
			while((sInfo = miIsrb.readLine()) != null)
			{
				System.out.println(sInfo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
