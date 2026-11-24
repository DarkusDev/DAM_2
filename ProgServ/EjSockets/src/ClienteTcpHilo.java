import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTcpHilo {
	static Socket cliente;
	static int iPuerto = 20000;
	static Writer wr = null;
	static InputStream iStr = null;
	static InputStreamReader riStr = null;
	static BufferedReader briStr = null;

	public static void main(String[] args) {
		Scanner miScan = new Scanner(System.in);
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
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Introduce la informacion para ECO o fin para terminar");
		String sEco = "";
		String sLinea = "";
		sEco = miScan.nextLine();
		while (!sEco.equalsIgnoreCase("ADIOS")) {
			try {
				wr.write(sEco + "\n");
				wr.flush();
				sLinea = briStr.readLine();
				System.out.println(sLinea);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Introduce la informacion para ECO o fin para terminar");
			sEco = miScan.nextLine();
		}
		try {
			wr.write("adios\n");
			wr.flush();
		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}