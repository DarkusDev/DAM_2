package EjAvanzado;

public class Proceso {
	private String nombre;
	private String ruta;
	
	public Proceso(String n, String r) {
		this.nombre = n;
		this.ruta = r;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getRuta() {
		return ruta;
	}
}
