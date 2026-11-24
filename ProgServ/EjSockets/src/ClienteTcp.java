import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTcp {
	static Socket cliente;
	static int iPuerto = 20000;
	static Writer wr = null;
	static InputStream iStr = null;
	static InputStreamReader riStr = null;
	static BufferedReader briStr = null;

	public static void main(String[] args) {
		try {
			cliente = new Socket("127.0.0.1", 20000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
// Activa flujo para lectura de informacion
		try {
			iStr = cliente.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		riStr = new InputStreamReader(iStr);
		briStr = new BufferedReader(riStr);
		try {
			wr = new OutputStreamWriter(cliente.getOutputStream(), "UTF-8");
			wr.write("Hola\n");
			wr.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sLinea = "";
		try {
			sLinea = briStr.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\t\t" + sLinea);
	}
}