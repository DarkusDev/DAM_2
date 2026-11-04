package EjIntroHilos;

import java.time.LocalTime;

public class Hilo2 implements Runnable{

	static String sNombre;

	public Hilo2(String sNombre){
		this.sNombre = sNombre;
	}
	
	public static String getName() {
		return sNombre;
	}
	
	@Override
	
	public void run() {
		System.out.println(LocalTime.now() + " " + sNombre + " activado");

        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println(LocalTime.now() + " " + sNombre + " ha descansado 2 segundos");

                long extra = (long) (Math.random() * 2001);   
                Thread.sleep(extra);
                System.out.println(LocalTime.now() + " " + sNombre + " ha descansado " + extra + " ms adicionales");

            } catch (InterruptedException e) {
                System.out.println(LocalTime.now() + " " + sNombre + " ha terminado (interrumpido)");
                return;   
            }
        }
		
	}
}
