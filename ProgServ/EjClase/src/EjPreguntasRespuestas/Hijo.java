package EjPreguntasRespuestas;

import java.util.Scanner;

public class Hijo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pregunta = "";
		
		pregunta = sc.nextLine();
		
		switch(pregunta) {
			case "¿Como estas?":
				System.out.println("Estoy bien");
				break;
			
			case "¿Cuantos años tienes?":
				System.out.println("1 año");
				break;
				
			case "¿Eres el proceso hijo?":
				System.out.println("Si");
				break;
				
			default:
				if(pregunta.equals("")) {
					System.out.println("No hay ninguna pregunta");
				}else {
					System.out.println("No entiendo tu pregunta");
				}
				
				break;
		}
			
	}

}
