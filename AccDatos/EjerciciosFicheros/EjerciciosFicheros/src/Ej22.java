import java.io.BufferedWriter;
import java.io.FileWriter;

public class Ej22 {
    public static void main(String[] args) {
        String[] nombres = {"Darius", "Karla", "Vlad"};
        int[] edades = {19, 18, 18};

        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter("./escribeNombreEdad"));

            for(int i = 0; i < nombres.length; i++){
                bWriter.write(nombres[i]);
                bWriter.newLine();
                bWriter.write((""+ edades[i]));
                bWriter.newLine();
            }

            bWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
