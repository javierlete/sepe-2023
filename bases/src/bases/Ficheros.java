package bases;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("ejemplo.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Hola");
		pw.println("Prueba");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader("ejemplo.txt");
		Scanner sc = new Scanner(fr);
		
		String linea;
		
		while(sc.hasNextLine()) {
			linea = sc.nextLine();
			System.out.println(linea);
		}
		
		sc.close();
		fr.close();
	}

}
