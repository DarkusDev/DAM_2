package EjTemporizadorHilos;

import java.util.ArrayList;
import java.util.TimerTask;

public class HiloLector extends TimerTask{

	String nombre;
	
	Monitor miMonitor = new Monitor();
	
	private String ultimaLeida;
	
	public HiloLector(Monitor miMonitor, String nombre) {
		this.nombre = nombre;
		this.miMonitor = miMonitor;
	}
	
	@Override
	public void run() {
		String listaPublicaciones = miMonitor.getLista();
		
		if(!listaPublicaciones.equals(ultimaLeida)) {
			System.out.println(nombre + " leyo: " + listaPublicaciones);
		}else {
			cancel();
			Principal.LectorDetenido = true;
			return;
		}
		
		ultimaLeida = listaPublicaciones;
		
		
	}
}
