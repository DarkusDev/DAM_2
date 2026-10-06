package EjMenu;

import java.util.Scanner;

public class EjMenuHijo{
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String opcionMenu = "";
		opcionMenu = sc.nextLine().toLowerCase();
		
		
		if(opcionMenu.equals("eco")) {
			String infoRecibida = "";
			infoRecibida = sc.nextLine();
			System.out.println("Hijo: " +infoRecibida);
			opcionMenu = "";
		}
		
		if(opcionMenu.equals("saludo")) {
			System.out.println("Hijo: " + " Hola proceso padre!");
			opcionMenu = "";
		}
		
		
	}
}