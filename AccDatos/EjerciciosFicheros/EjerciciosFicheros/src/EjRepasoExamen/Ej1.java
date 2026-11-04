package EjRepasoExamen;

import java.io.RandomAccessFile;

public class Ej1 {
    public static void main(String[] args) {
        Escribir();
        Leer();
    }

    public static void Escribir() {
        String[] nombres = { "AccDatos", "ProgJava", "PSP" };
        int[] horas = { 200, 250, 180 };
        String[] cursos = { "Segundo", "Primero", "Segundo" };

        StringBuilder sBuilder;

        try {
            RandomAccessFile rAccessFile = new RandomAccessFile("./modulosdam.dat", "rw");
            for (int i = 0; i < nombres.length; i++) {
                rAccessFile.writeInt(i + 1);

                sBuilder = new StringBuilder(nombres[i]);
                sBuilder.setLength(10);
                rAccessFile.writeChars(sBuilder.toString());

                rAccessFile.writeInt(horas[i]);

                sBuilder = new StringBuilder(cursos[i]);
                sBuilder.setLength(10);
                rAccessFile.writeChars(sBuilder.toString());
            }

            System.out.println("Pos: " + rAccessFile.getFilePointer());
            rAccessFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void Leer(){
        try {
            RandomAccessFile rAccessFile = new RandomAccessFile("./modulosdam.dat", "rw");

            int id = 0;
            String nombres = "";
            int horas = 0;
            String cursos = "";

            while (rAccessFile.getFilePointer() < rAccessFile.length()) {
                id = rAccessFile.readInt();

                char[] letras = new char[10];
                for (int i = 0; i < letras.length; i++) {
                    letras[i] = rAccessFile.readChar();
                }

                nombres = new String(letras).trim();

                horas = rAccessFile.readInt();

                char[] letras2 = new char[10];
                for (int i = 0; i < letras2.length; i++) {
                    letras2[i] = rAccessFile.readChar();
                }

                cursos = new String(letras2).trim();

                System.out.println("Id: " + id + " nombre: " + nombres + " horas: " + horas
                        + " curso: " + cursos);

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }

