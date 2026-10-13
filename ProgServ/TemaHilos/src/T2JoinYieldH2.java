public class T2JoinYieldH2 extends Thread {
	String sNombre;
	public T2JoinYieldH2(String sNombre)
	{
		this.sNombre = sNombre;
	}
	@Override
	public void run ()
	{
		System.out.println("Inciando "+ sNombre);
		
		for (int i = 0; i < 500; i++)
		{
				System.out.println(sNombre + " Pasada: " + i);
		}
		
		System.out.println("Terminando "+ sNombre);		
	}
}