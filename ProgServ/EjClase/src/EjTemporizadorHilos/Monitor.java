package EjTemporizadorHilos;

import java.util.ArrayList;

public class Monitor {

	private String publicaciones;
	private int numPublicacion = 0;
	
	public synchronized void NuevaPublicacion() {
		numPublicacion++;
		publicaciones = ("Publicacion " + numPublicacion);
	}
	
	public String getLista(){
		return publicaciones;
	}
}
