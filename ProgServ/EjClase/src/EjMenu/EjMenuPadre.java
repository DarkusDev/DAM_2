package EjMenu;

import java.util.Scanner;
import java.io.*;

public class EjMenuPadre {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcionMenu = "";
		String textoAMandar = "";

		Writer w = null;
		ProcessBuilder pBuilder = new ProcessBuilder("/usr/java/jdk-24.0.2/bin/java", "EjMenu.EjMenuHijo");
		pBuilder.directory(new File("./bin"));
		Process process = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		boolean menuActivo = true;
		
		try {
			process = pBuilder.start();
			bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		while (menuActivo) {
			try {
				System.out.println("Menu de Opciones. Pulsa:");
				System.out.println("* Eco : para recibr un eco del otro proceso");
				System.out.println("* Saludo : para recibr Hola del otro proceso");
				System.out.println("* Vivo : para comprobar si el otro proceso esta vivo");
				System.out.println("* Matar : para finalizar el otro proceso");
				System.out.println("* Resucitar : para activar otro proceso hijo");
				System.out.println("* Salir : para salir del programa");
				System.out.println("* Indica tu opcion: ");

				opcionMenu = sc.nextLine().toLowerCase();

				
				String info = "";
				switch (opcionMenu) {
					case "eco":
	
						System.out.println("Introduce el texto que quieres mandar al proceso hijo: ");
						textoAMandar = sc.nextLine();
	
						bw.write("Eco");
						bw.newLine();
						bw.write(textoAMandar);
						bw.newLine();
						bw.flush();
	
						info = br.readLine();
	
						System.out.println(info);
	
						break;
	
					case "saludo":
	
						bw.write("saludo");
						bw.newLine();
						bw.flush();
	
						info = br.readLine();
	
						System.out.println(info);
						
						break;
						
					case "vivo":
						
						System.out.println("El proceso hijo esta activo? " + process.isAlive());
						
						break;
						
					case "matar":
						process.destroy();
						System.out.println("El proceso hijo fue finalizado");
						break;
						
					case "resucitar":
						process = pBuilder.start();
						System.out.println("El proceso hijo se ha iniciado");
						break;
						
					case "salir":
						menuActivo = false;
						break;
					

				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}

		}

	}
}