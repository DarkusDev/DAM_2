package EjIntroHilos;

public class EjIntroHilos {

	public static void main(String [] args) {
		
		
		
		
		/*Version1
			Hilo1 hilo1 = new Hilo1("Hilo 1"); 
			hilo1.start();
			
			Thread hilo2 = new Thread(new Hilo2("Hilo 2"));
			hilo2.start();
			
			try {
				
				Thread.sleep(3000);
				
				hilo1.interrupt();
				hilo2.interrupt();
				
				hilo1.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			System.out.println("Programa padre termino");
		*/
		
		/*Verion2
		
			Hilo1 hilo1 = new Hilo1("Hilo 1"); 
			hilo1.start();
			
			Thread hilo2 = new Thread(new Hilo2("Hilo 2"));
			hilo2.start();
			
			try {
				
				Thread.sleep(3000);
				
				hilo1.interrupt();
				hilo2.interrupt();
				
				hilo2.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			System.out.println("Programa padre termino");
		*/
		
		/*Version3
			Hilo1 hilo1 = new Hilo1("Hilo 1"); 
			hilo1.start();
			
			Thread hilo2 = new Thread(new Hilo2("Hilo 2"));
			
			
			try {
				
				Thread.sleep(3000);
				
				hilo1.interrupt();
				
				
				hilo1.join();
				
				hilo2.start();
				
				Thread.sleep(3000);
				
				hilo2.interrupt();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			System.out.println("Programa padre termino");
		*/
		
		//VersionCompleta
		
			Hilo1 hilo1 = new Hilo1("Hilo 1"); 
			
			
			Thread hilo2 = new Thread(new Hilo2("Hilo 2"));
			hilo2.start();
			
			try {
				Thread.sleep(10000);
				hilo2.interrupt();
				hilo2.join();
	
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			System.out.println("Programa padre termino");
		
	}

}

