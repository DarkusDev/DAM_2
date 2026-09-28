import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PruebaFicherosBytes {
    public static void main(String[] args) throws IOException {
        GrabarArray();
    }

    public static void GrabarArray() throws IOException {
        FileOutputStream fw = new FileOutputStream("./datos.mbd", false);
        DataOutputStream ds = new DataOutputStream(fw);

        int[] m = { 5, 10, 3, 6 };

        for (int i = 0; i < m.length; i++) {
            ds.writeInt(m[i]);
        }

        ds.close();
        VolcarArray();
    }

    public static void VolcarArray() throws IOException{
        DataInputStream ds = new DataInputStream(new FileInputStream ("./datos.mbd"));
        try {
            for (;;){ //bucle infinito
                System.out.println(ds.readInt());
            }
        } catch(EOFException e){

        ds.close(); 
        }
    }
}
