import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Ej15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numMes;
        String letraMes = "";

        System.out.println("Escribe el numero de un mes: ");
        numMes = Integer.parseInt(sc.nextLine());

        System.out.println("Con que letra empieza el primer dia de ese mes?: ");
        letraMes = sc.nextLine();
        int x = 0;

        if (numMes % 2 == 0 && numMes != 2) {
            x = 30;
        } else if (numMes % 2 != 0 && numMes != 2) {
            x = 31;
        } else {
            x = 28;
        }
        int[] numDiasMes = new int[x];

        String[] nombreDiasMes = new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado",
                "Domingo" };

        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter("./calendario.txt"));
            int j = 0;

            switch (letraMes) {
                case "L":
                    j = 0;
                    break;
                case "M":
                    j = 1;
                    break;
                case "X":
                    j = 2;
                    break;
                case "J":
                    j = 3;
                    break;
                case "V":
                    j = 4;
                    break;
                case "S":
                    j = 5;
                    break;
                case "D":
                    j = 6;
                    break;
            }
            for (int i = 1; i <= numDiasMes.length; i++) {
                bWriter.write("Dia: " + i + " " + nombreDiasMes[j]);
                bWriter.newLine();
                j++;

                if (j == 7) {
                    j = 0;
                }
            }

            bWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
