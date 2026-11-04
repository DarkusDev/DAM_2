package EjIntroHilos;

public class Hilo1 extends Thread{

	String sNombre;

	public Hilo1(String sNombre){
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
