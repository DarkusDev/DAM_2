import java.io.*;
import java.util.Scanner;

public class BackEnd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter("./clientes.txt"));
			bWriter.write("Darius#1000");
			bWriter.newLine();
			bWriter.flush();
			bWriter.write("Karla#2000");
			bWriter.newLine();
			bWriter.flush();
			
			bWriter.close();
			
			
			BufferedReader bReader = new BufferedReader(new FileReader("./clientes.txt"));
			String lineaString = "";
			while((lineaString = bReader.readLine()) != null) {
				System.out.println(lineaString);
			}
			
			//String info = sc.nextLine();
			//bWriter.write(info);
			
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		

	}
	
	

}
