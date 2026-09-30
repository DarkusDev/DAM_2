import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StreamTokenizer;

public class Ej23 {
    public static void main(String[] args) {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader("./escribeNombreEdad"));
            StreamTokenizer sTokenizer = new StreamTokenizer(new FileReader("./escribeNombreEdad"));
            String[] nombres = new String[3];
            int[] edad = new int[3];

            int i = 0;
            int x = 0;
            String info = "";

            while ((info = bReader.readLine()) != null) {
                    sTokenizer.nextToken();
                    if (sTokenizer.ttype == StreamTokenizer.TT_WORD) {
                        nombres[i] = info;
                        i++;
                    }

                    else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                        edad[x] = Integer.parseInt(info);
                        x++;
                    }
                    
                }
            

            for (int j = 0; j < nombres.length; j++) {
                System.out.println("Nombre: " + nombres[j] + "Edad: " + edad[j]);
            }

            bReader.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
