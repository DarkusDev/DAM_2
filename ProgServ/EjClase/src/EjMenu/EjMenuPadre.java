package EjMenu;
import java.util.Scanner;
import java.io.*;

public class EjMenuPadre{
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String opcionMenu = "";
		String textoAMandar = "";
		
		Writer w = null;
		ProcessBuilder pBuilder = new ProcessBuilder("/usr/java/jdk-24.0.2/bin/java","EjMenu.EjMenuHijo");
		pBuilder.directory(new File("./bin"));
		while(true) {
			System.out.println("Menu de Opciones. Pulsa:");
			System.out.println("* Eco : para recibr un eco del otro proceso");
			System.out.println("* Saludo : para recibr Hola del otro proceso");
			System.out.println("* Vivo : para comprobar si el otro proceso esta vivo");
			System.out.println("* Matar : para finalizar el otro proceso");
			System.out.println("* Resucitar : para activar otro proceso hijo");
			System.out.println("* Salir : para salir del programa");
			System.out.println("* Indica tu opcion: ");
			
			opcionMenu = sc.nextLine();
			
			switch(opcionMenu) {
				case "Eco":
					
					try {
						
						System.out.println("Introduce el texto que quieres mandar al proceso hijo: ");
						textoAMandar = sc.nextLine();
						Process process = pBuilder.start();
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
				        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

						bw.write("Eco");
						bw.newLine();
						bw.write(textoAMandar);
						bw.newLine();
						bw.flush();
						
				        String info = br.readLine();
				        
				        System.out.println(info);
				        
				        
					}catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
					}
					
					break;
			}
		}
		
	}
}