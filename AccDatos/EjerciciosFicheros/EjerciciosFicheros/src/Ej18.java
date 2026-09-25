import java.util.Scanner;

public class Ej18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("El numero " + PideEntero(sc) + " es correcto!");
    }

    public static int PideEntero(Scanner sc) {
        int numEntero = 0;
        boolean numCorrecto = false;
        try {
            do {
                System.out.println("Introduce un numero entero valido: ");
                numEntero = sc.nextInt();
                numCorrecto = true;
                
            } while (!numCorrecto);

            return numEntero;
        } catch (Exception e) {
            System.out.println("Error: El numero introducido no es un numero entero valido, prueba de nuevo: ");
            sc.next();
            return PideEntero(sc);
        }

    }
}
