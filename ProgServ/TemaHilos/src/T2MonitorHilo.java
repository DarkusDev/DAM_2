public class T2MonitorHilo extends Thread {

	T2MonitorComp zonaComp;
	String sNombre;
	
	public T2MonitorHilo (T2MonitorComp zonaComp, String sNombre)
	{
		this.zonaComp = zonaComp;
		this.sNombre = sNombre;
	}
	
	@Override
	public void run() {
		for (int i = 0 ; i < 600000; i++)
		{
			zonaComp.IncrementaCon();
			System.out.println("Soy " + sNombre + ": " + zonaComp.getContador());
		}
	}
}