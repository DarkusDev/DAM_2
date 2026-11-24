import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUdp {
	public static void main(String[] args) {
// Crea el socket UDP
		DatagramSocket miDs = null;
		try {
			miDs = new DatagramSocket(20000);
		} catch (SocketException e) {
			e.printStackTrace();
		}
// Crea el Datagrama de lectura UDP
		byte[] bufLect = new byte[64];
		DatagramPacket mdDp = new DatagramPacket(bufLect, bufLect.length);
		System.out.println("Esperando mensaje de entrada desde el cliente");
		try {
			miDs.receive(mdDp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Info recibida: " + new String(bufLect));
// Crea el Datagrama de escritura UDP
		System.out.println("Enviando mensaje de salida al cliente");
		byte[] bufEsc = new String("Men. UDP enviado").getBytes();
		DatagramPacket miDpSal = null;
		miDpSal = new DatagramPacket(bufEsc, bufEsc.length, mdDp.getAddress(), mdDp.getPort());
		try {
			miDs.send(miDpSal);
		} catch (IOException e) {
			e.printStackTrace();
		}
		miDs.close();
	}
}