import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTcpHilos {
	static ServerSocket servidor;
	static int iPuerto = 20000;
	static Writer wr = null;
	static InputStream iStr = null;
	static InputStreamReader riStr = null;
	static BufferedReader briStr = null;

	public static void main(String[] args) {
		int iNumClientes = 0;
		try {
			servidor = new ServerSocket(iPuerto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Esperando conexion desde clientes");
		while (true) {
			Socket conexion = null;
			try {
				conexion = servidor.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Cliente conectado en " + conexion.getInetAddress());
			System.out.println(conexion);
			ServTcpHilo hiloHijo = new ServTcpHilo(conexion);
			hiloHijo.start();
		}
	}
}