import java.io.RandomAccessFile;

public class Ej25 {
    public static void main(String[] args) {
        try {
            RandomAccessFile rAccessFile = new RandomAccessFile("./ficheroEmpleados.dat", "rw");

            int id = 0;
            String apellido = "";
            int departamento = 0;
            double salario = 0;

            while (rAccessFile.getFilePointer() < rAccessFile.length()) {
                id = rAccessFile.readInt();

                char[] letras = new char[10];
                for (int i = 0; i < letras.length; i++) {
                    letras[i] = rAccessFile.readChar();
                }

                apellido = new String(letras).trim();

                departamento = rAccessFile.readInt();

                salario = rAccessFile.readDouble();

                System.out.println("Id: " + id + " apellido: " + apellido + " departamento: " + departamento
                        + " salario: " + salario);

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
