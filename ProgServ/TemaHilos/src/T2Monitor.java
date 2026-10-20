public class T2Monitor {
	public static void main(String[] args) {
		T2MonitorComp miMonitor = new T2MonitorComp();

		T2MonitorHilo miHiloUno = new T2MonitorHilo(miMonitor, "Hilo Uno");
		T2MonitorHilo miHiloDos = new T2MonitorHilo(miMonitor, "Hilo Dos");
		T2MonitorHilo miHiloTres = new T2MonitorHilo(miMonitor, "Hilo Tres");
		T2MonitorHilo miHiloCuatro = new T2MonitorHilo(miMonitor, "Hilo Cuatro");
		T2MonitorHilo miHiloCinco = new T2MonitorHilo(miMonitor, "Hilo Cinco");
		T2MonitorHilo miHiloSeis = new T2MonitorHilo(miMonitor, "Hilo Seis");
			
		miHiloUno.start();
		miHiloDos.start();
		miHiloTres.start();
		miHiloCuatro.start();
		miHiloCinco.start();
		miHiloSeis.start();
		
		try {
			miHiloUno.join();
			miHiloDos.join();
			miHiloTres.join();
			miHiloCuatro.join();
			miHiloCinco.join();
			miHiloSeis.join();
		} catch (InterruptedException e) {	e.printStackTrace();}

		System.out.println(miMonitor.getContador());
	}
}