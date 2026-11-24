import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.Writer;

public class ServidorTcp {
	static ServerSocket servidor;
	static Socket conexion;
	static int iPuerto = 20000;
	static Writer wr = null;
	static InputStream iStr = null;
	static InputStreamReader riStr = null;
	static BufferedReader briStr = null;

	public static void main(String[] args) {
		try {
			servidor = new ServerSocket(iPuerto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Esperando conexion desde cliente");
		try {
			conexion = servidor.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente conectado en " + conexion.getInetAddress());
//
		System.out.println("Cliente conectado en " + conexion.getInetAddress().getHostName());
		try {
// Activa flujo para lectura de informacion
			iStr = conexion.getInputStream();
			riStr = new InputStreamReader(iStr);
			briStr = new BufferedReader(riStr);
			wr = new OutputStreamWriter(conexion.getOutputStream(), "UTF-8");
			wr.write("Hola\n");
			wr.flush();

			String sLinea = briStr.readLine();
			System.out.println("\t\t" + sLinea);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}