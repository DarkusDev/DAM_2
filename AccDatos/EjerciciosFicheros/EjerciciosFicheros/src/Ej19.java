import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (RespuestaPregunta(sc)) {
            System.out.println("Gracias por responder! A mi tambien me gusta.");
        } else{
            System.out.println("Gracias por responder! Tu te lo pierdes");
        }
    }

    public static boolean RespuestaPregunta(Scanner sc) {
        String respuesta = "";
        boolean respuestaCorrecta = false;
        try {
            do {
                System.out.println("Te gusta la pizza?");
                respuesta = sc.nextLine();

                if (respuesta.equals("S") || respuesta.equals("s")) {
                    respuestaCorrecta = true;
                } else if (respuesta.equals("N") || respuesta.equals("n")) {
                    respuestaCorrecta = true;
                    return false;
                } else {
                    System.out.println(respuesta + " No es una respuesta correcta");
                }
            } while (!respuestaCorrecta);

            return true;
        } catch (Exception e) {
            System.out.println(respuesta + "No es una respuesta correcta");
            sc.next();
            return RespuestaPregunta(sc);

        }

    }
}
