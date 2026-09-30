package EjIntro;
public class EjIntroPrueba {
	public static void main(String[] args) {
		System.out.println("Darius");
		System.out.println("EjIntroPrueba");
		
		try {
			Thread.sleep(5000);
		}catch (InterruptedException ie) {
			System.out.println("Error: " + ie.getMessage());
		}
		
		System.exit(5);
	}
}
