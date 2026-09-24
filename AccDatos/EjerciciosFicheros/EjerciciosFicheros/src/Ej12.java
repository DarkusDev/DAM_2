import java.io.BufferedReader;
import java.io.FileReader;

public class Ej12 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./numNaturales"));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
