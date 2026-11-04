package EjTemporizadorHilos;

import java.security.PublicKey;
import java.util.Timer;
public class Principal {

	public static boolean LectorDetenido;
	
	public static void main(String[] args) {
		
		
		Timer miTimerEscritor = new Timer();
		Timer miTimerLector = new Timer();
		Monitor miMonitor = new Monitor();
		
		boolean EscritorDetenido = false;
		
		
		miTimerEscritor.schedule(new HiloEscritor(miMonitor, "Hilo Escritor"), 1000,2000);
		miTimerLector.schedule(new HiloLector(miMonitor, "Hilo Lector"), 2000,2000);
		
		try {
			Thread.sleep(6000);
			
			miTimerEscritor.cancel();
			EscritorDetenido = true;
			
			while(!LectorDetenido) {
				Thread.sleep(100);
			}
			
			miTimerLector.cancel();
			
			
			
			System.out.println("Todos los hilos detenidos, adios");
			
		}catch(InterruptedException e) {
			
		}
		
		
	}
	
	

}
