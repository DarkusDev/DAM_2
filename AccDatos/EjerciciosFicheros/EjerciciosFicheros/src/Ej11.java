import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.management.StringValueExp;

public class Ej11 {

    public static void main(String[] args) {
        int num = 0;
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("numNaturales.txt"));
            
            for(int i = 0; i < 100; i++){
                bw.write(String.valueOf(i));
                bw.newLine();
                
            }

            System.out.println("Numeros impresos");
            bw.close();
        } catch (Exception e) {
            
        }
        
    }
}
