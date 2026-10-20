public class T2JoinYieldH1 extends Thread {
	String sNombre;
	public T2JoinYieldH1(String sNombre)
	{
		this.sNombre = sNombre;
	}
	@Override
	public void run ()
	{
		System.out.println("Inciando "+ sNombre);
		for (int i = 0; i < 500; i++)
		{
			if (i==5) {
				 this.yield();
				//try { Thread.sleep(0); } 
				//catch (InterruptedException e) { e.printStackTrace(); }
			}
			System.out.println(sNombre + " Pasada: " + i);
		}
		System.out.println("Terminando "+ sNombre);
	}
}