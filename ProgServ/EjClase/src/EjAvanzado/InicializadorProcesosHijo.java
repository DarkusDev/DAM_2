package EjAvanzado;

import java.util.Scanner;
import java.io.*;

public class InicializadorProcesosHijo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String rutaFichero = sc.nextLine();
		
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(rutaFichero));
			
			String linea = "";
			int numRandom = (int) (Math.random() * 3) + 1;
			Thread.sleep(numRandom * 1000);
			while((linea = bReader.readLine()) != null) {
				System.out.println(linea.toString());
			}

		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}

}
