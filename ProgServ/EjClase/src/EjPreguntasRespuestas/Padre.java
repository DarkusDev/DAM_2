package EjPreguntasRespuestas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Padre {

	public static void main(String[] args) {
		String java = System.getProperty("java.home") + "/bin/java";
		String cp = System.getProperty("java.class.path");
		
		Scanner sc = new Scanner(System.in);
		boolean menuActivo = true;
		String pregunta = "";
		ProcessBuilder pBuilder = null;
		Process process = null;
		BufferedWriter bWriter = null;
		BufferedReader bReader = null;
		
		while(menuActivo) {
			try {
				System.out.println("Hazme una pregunta: ");
				pregunta = sc.nextLine();
				if(pregunta.equalsIgnoreCase("FIN")) {
					menuActivo = false;
					break;
				}
				pBuilder = new ProcessBuilder(java, "-cp", cp, "EjPreguntasRespuestas.Hijo");
				process = pBuilder.start();
				bWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
				bWriter.write(pregunta);
				bWriter.newLine();
				bWriter.flush();
				
				
				bReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				System.out.println(bReader.readLine());
				
			} catch(Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			
		}

	}

}
