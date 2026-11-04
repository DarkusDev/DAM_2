package EjTemporizadorHilos;

import java.util.TimerTask;

public class HiloEscritor extends TimerTask{

	String nombre;
	
	Monitor miMonitor = new Monitor();
	
	public HiloEscritor(Monitor miMonitor, String nombre) {
		this.nombre = nombre;
		this.miMonitor = miMonitor;
	}
	
	@Override
	public void run() {
		miMonitor.NuevaPublicacion();
	}
}


