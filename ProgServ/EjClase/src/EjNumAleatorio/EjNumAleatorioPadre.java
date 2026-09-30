package EjNumAleatorio;
import java.io.*;
import java.util.Scanner;

public class EjNumAleatorioPadre{
	public static void main(String [] args) {
		ProcessBuilder pBuilder = new ProcessBuilder("/usr/java/jdk-24.0.2/bin/java","EjNumAleatorio.EjNumAleatorioHijo");
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
            System.out.println("Introduce algo para pedir un numero al hijo: ");
            String infoMandar = sc.nextLine();
            if (infoMandar.equalsIgnoreCase("fin")) {
                break;
            }

      
            pBuilder.directory(new File("./bin"));

            try {
                Process process = pBuilder.start();          
                int info = process.waitFor();                
                System.out.println(process.pid());
                System.out.println("Número aleatorio devuelto por el hijo: " + info);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
		
		System.out.println("Programa cerrado");
		
		
	}
}