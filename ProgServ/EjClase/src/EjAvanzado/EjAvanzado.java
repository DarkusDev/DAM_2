package EjAvanzado;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import EjAvanzado.Proceso;

public class EjAvanzado {

	public static void main(String[] args) {
		try {
			String java = System.getProperty("java.home") + "/bin/java";
			String cp = System.getProperty("java.class.path");
			BufferedReader br = new BufferedReader(new FileReader("/media/sf_ProgServ/EjClase/src/EjAvanzado/procesos.txt"));
			String info = "";
			ArrayList<Proceso> listaProcesos = new ArrayList<>();
			
			while((info = br.readLine()) != null) {
				String palabras[] = info.trim().split("\\s+");
				listaProcesos.add(new Proceso(palabras[0], palabras[1]));
			}
			
			ProcessBuilder pBuilder;
			ArrayList<Process> procHijos = new ArrayList<>();
			Process process = null;
			BufferedWriter bw = null;
			BufferedReader bRP = null;
			
			ArrayList<String> nombres = new ArrayList<>();
			
			for(Proceso p : listaProcesos) {
				

				pBuilder = new ProcessBuilder(java, "-cp", cp, "EjAvanzado.InicializadorProcesosHijo");
				process = pBuilder.start();
				
				bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
				
				bw.write(p.getRuta().toString());
				bw.newLine();
				bw.flush();
				procHijos.add(process);
				
			}
			
			for(Process p : procHijos) {
				bRP = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				String linea = "";
				
				while((linea = bRP.readLine()) != null) {
					nombres.add(linea);
				}
			}
			Collections.sort(nombres);
			for(String nombre : nombres) {
				System.out.println(nombre);
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		

	}

}
