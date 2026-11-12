
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class FrontEnd {

public static ArrayList<String> listaClientes = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String opcionUsuario = "";
		boolean menuActivo = true;
		ProcessBuilder processBuilder = new ProcessBuilder("/usr/java/jdk-24.0.2/bin/java", "BackEnd");
		processBuilder.directory(new File("./bin"));
		Process proceso = null;
		try {
			proceso = processBuilder.start();
			
			Thread.sleep(1000);
			
			BufferedReader bReader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
			String linea = "";
			
			while((linea = bReader.readLine()) != null ) {
				listaClientes.add(linea);
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		while(menuActivo) {
			System.out.println("Gestor de bancos. Elige una opcion: ");
			System.out.println("1 - Saldo");
			System.out.println("2 - Ingreso");
			System.out.println("3 - Salir");
			
			opcionUsuario = sc.nextLine();
			
			switch (opcionUsuario) {
				case "1":
					for(String nombre : listaClientes) {
						int i = 0;
						String[] info = new String[2];
						info = nombre.trim().split("#");
						
						System.out.println("El nombre del cliente es: " + info[0] + " y su saldo es: " + info[1]);
						
					}
					break;
					
				
				case "2":
					String opcionelegidaString = "";
					for(String nombre : listaClientes) {
						int i = 0;
						String[] info = new String[2];
						info = nombre.trim().split("#");
						
						System.out.println("El nombre del cliente es: " + info[0] + " y su saldo es: " + info[1]);
					
					}
					
					System.out.println("Selecciona el cliente: ");
					opcionelegidaString = sc.nextLine();
					
					for(String nombre : listaClientes) {
						String[] info = new String[2];
						info = nombre.trim().split("#");
						if(opcionelegidaString.equals(info[0])) {
							int cantIngreso = 0;
							System.out.println("Cuanto quieres ingresar?: ");
							cantIngreso = Integer.parseInt(sc.nextLine());
							
							try {
								BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
								bWriter.write("" + info[0] + (info[1] + cantIngreso));
								bWriter.newLine();
								bWriter.flush();
								bWriter.close();
								
							} catch (Exception e) {
								System.out.println("Error: " + e.getMessage());

							}
						}else {
							System.out.println("Cliente no existe");
							break;
						}
					}
					break;
					
				case "3":
					menuActivo = false;
					break;
					
				default:
					System.out.println("Error: Valor no valido");
					
			}
		}
		
		
		

	}

}
