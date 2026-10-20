public class T2MonitorComp {
	private int iContador = 0;
	
	public synchronized void IncrementaCon ()
	 //public void IncrementaCon ()
	{
		iContador = iContador + 1;
	}
	
	public int getContador ()
	{
		return iContador;
	}
}