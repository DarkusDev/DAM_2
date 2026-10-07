package EjJuegoProcesos;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class ProgPrincipal {

	static Scanner sc = new Scanner(System.in);
	static String opcionMenu = "";
	static boolean menuActivo = true;
	static BufferedReader bReader = null;
	static BufferedWriter bWriter = null;
	
	static String java = System.getProperty("java.home") + "/bin/java";
	static String cp = System.getProperty("java.class.path");
	static ProcessBuilder pBuilder = null;
	static Process process = null;
	
	static ArrayList<Process> listaProcesos = new ArrayList<>();
	
	public static void main(String[] args) {

		try {
			while (menuActivo) {
				imprimeMenu();

			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			sc.next();
			imprimeMenu();
		}

	}

	public static void imprimeMenu() {

		System.out.println("MENU: ");
		System.out.println("1- Jugar");
		System.out.println("2- MostrarLogJuego");
		System.out.println("3- Salir");
		opcionMenu = sc.nextLine();

		switch (opcionMenu) {
			case "1":
				System.out.println("Has elegido jugar");
				pBuilder = new ProcessBuilder(java, "-cp", cp, "EjAvanzado.InicializadorProcesosHijo");
				int numEnemigos = (int) (Math.random() * 5) + 1;
				
				for(int i = 0; i < numEnemigos; i++) {
					try {
						process = pBuilder.start();
						listaProcesos.add(process);
						//System.out.println(process.pid());

					}catch(Exception e) {
						System.out.println("Error: " + e.getMessage());
					}
				}
				
				System.out.println("Hay " + numEnemigos + " enemigos");
				
				for(Process p : listaProcesos) {
					
					int probGanar = (int) (Math.random() * 101) + 1;
					String decisionJugador = "";
					System.out.println("La probabilidad de matar al enemigo " + p.pid() + " es de: " + probGanar + " %");
					
					System.out.println("Desea intentar matar al enemigo?");
					
					decisionJugador = sc.nextLine();
					
					if(decisionJugador.equalsIgnoreCase("si")) {
						int probMatar = (int) (Math.random() * 101) + 1;
						
						if(probMatar <= probGanar) {
							System.out.println("El enemigo " + p.pid() + " ha sido derribado");
							p.destroy();
							
						}else {
							System.out.println("El enemigo " + p.pid() + " no ha sido derribado");
						}
					}
					
				}
				imprimeMenu();
				break;
				
			case "2":
				System.out.println("Has elegido mostrarLog");
				imprimeMenu();
				break;
	
			case "3":
				System.out.println("Has elegido salir");
					menuActivo = false;
				break;
			
			default:
				System.out.println("Valor introducido invalido.");
				imprimeMenu();
				break;
		}
	}

}
