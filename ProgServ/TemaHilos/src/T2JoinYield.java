// Probar.
//  - Iniciar dos hilos con join. Probar dif. vueltas en bucle de los hijos.
//  - Con muchas hay cambios de procesos y Con join el mensaje Termina programa sale al final
//  - Iniciar los dos hilos, sin join y probar con muchas vueltas. Termina programa sale entre medias de los mensajes 
//
//   - En hijouno, meter yield. Hace que se salga y da paso al hijo dos, al padre o podría volver a ser planificado el hilo 1

//		Thread.sleep(0); es equivalente a yield	
public class T2JoinYield {
	public static void main (String [] args)
	{
		T2JoinYieldH1 hijoUno = new T2JoinYieldH1("Hijo uno");
		T2JoinYieldH2 hijoDos = new T2JoinYieldH2("Hijo dos");
		hijoUno.start();
		hijoDos.start();	
		
		try { hijoUno.join();} 
		catch(InterruptedException e) {	e.printStackTrace();}
		try { hijoDos.join(); } 
		catch (InterruptedException e) { e.printStackTrace(); }

		System.out.println("Termina programa");
	}
}