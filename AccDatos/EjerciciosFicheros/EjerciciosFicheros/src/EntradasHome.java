import java.io.File;


public class EntradasHome {
    public static void main(String[] args) {
        File home = new File("/home/alumnom");
        int i = 0;

        

        try {
            String[] salidas = home.list();

            for (String respuestas : salidas) {
                System.out.println(respuestas);
            }
            
        } catch (Exception ioe) {
            System.out.println("Error " + ioe.getMessage());
        }
        
    }
}
