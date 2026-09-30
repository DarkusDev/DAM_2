import java.io.RandomAccessFile;

public class Ej24 {
    public static void main(String[] args) {

        String[] apellidos = { "Puiu", "Cuevas", "Bonilla" };
        int[] departamentos = { 2, 4, 6 };
        double[] salarios = { 2000.5, 1900.99, 2300.25 };

        StringBuilder sBuilder;

        try {
            RandomAccessFile rAccessFile = new RandomAccessFile("./ficheroEmpleados.dat", "rw");
            for (int i = 0; i < apellidos.length; i++) {
                rAccessFile.writeInt(i + 1);

                sBuilder = new StringBuilder(apellidos[i]);
                sBuilder.setLength(10);
                rAccessFile.writeChars(sBuilder.toString());

                rAccessFile.writeInt(departamentos[i]);

                rAccessFile.writeDouble(salarios[i]);
            }

            System.out.println("Pos: " + rAccessFile.getFilePointer());
            rAccessFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
