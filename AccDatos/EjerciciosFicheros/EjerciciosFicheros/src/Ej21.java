import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.StreamTokenizer;

public class Ej21 {
    public static void main(String[] args) {
        StreamTokenizer sTokenizer = null;
        int numeros = 0, palabras = 0;

        try {
            sTokenizer = new StreamTokenizer(new FileReader("./ficheroNumPal.txt"));
            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (sTokenizer.ttype == StreamTokenizer.TT_WORD)
                    palabras++;
                else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER)
                    numeros++;
            }

            System.out.println("Numero de palabras: " + palabras);
            System.out.println("Numero de numeros: " + numeros);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
