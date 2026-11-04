package EjIntroHilos;

public class Hilo2 implements Runnable{

	String sNombre;

	public Hilo2(String sNombre){
		this.sNombre = sNombre;
	}
	
	@Override
	
	public void run() {
		System.out.println("Iniciando: " + sNombre);
		int i = 0;
		
		while(true) {
			System.out.println("Hilo: " +sNombre + "paso: " + i);
			i++;
		}
	}
}
