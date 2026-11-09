import java.util.ArrayList;

public class Monitor {

    private ArrayList<String> listaNombres = new ArrayList<>();

    private int[] contadores = new int[10];
    private int noRespondidos;

    public synchronized void escribeLista(String nombre) {
        listaNombres.add(nombre);
    }

    public synchronized ArrayList<String> getLista() {
        return listaNombres;
    }

    public synchronized void sumaColor(int numero) {
        contadores[numero]++;
    }

    public synchronized void sumaSinRespueta() {
        noRespondidos++;
    }

    public int[] getContadores() {
        return contadores;
    }

    public int getNoRespondidos() {
        return noRespondidos;
    }

}
