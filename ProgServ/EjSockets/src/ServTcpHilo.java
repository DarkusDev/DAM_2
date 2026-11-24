import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ServTcpHilo extends Thread {
	Socket miSock = null;
	Writer wr = null;
	InputStream iStr = null;
	InputStreamReader riStr = null;
	BufferedReader briStr = null;

	public ServTcpHilo(Socket miSock) {
		this.miSock = miSock;
	}

	@Override
	public void run() {
		try {
// Activa flujo para lectura de informacion
			iStr = miSock.getInputStream();
			riStr = new InputStreamReader(iStr);
			briStr = new BufferedReader(riStr);
			wr = new OutputStreamWriter(miSock.getOutputStream(), "UTF-8");
			String sLinea = "aaa";
			while (!sLinea.equalsIgnoreCase("adios")) {
				if (briStr.ready()) {
					sLinea = briStr.readLine();
					System.out.println("\t" + sLinea);
					wr.write("Eco: " + sLinea + "\n");
					wr.flush();
				}
			}
			System.out.println("Cliente se marcha");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}