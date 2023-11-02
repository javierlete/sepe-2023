package bases;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) {
		FileWriter fw = null;
		PrintWriter pw = null;

		// try_catch_finally anterior a Java 7
		try {
			fw = new FileWriter("ejemplo.txt");
			pw = new PrintWriter(fw);

			pw.println("Hola");
			pw.println("Prueba");
		} catch (IOException e) {
			System.err.println("No se ha podido CREAR el fichero");
		} finally {
			if (pw != null) {
				pw.close();
			}

			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println("No se ha podido CERRAR el fichero");
				}
			}
		}

		// try_with_resource (Java 7)
		try (FileReader fr = new FileReader("ejemplo.txt");
				Scanner sc = new Scanner(fr)) {
			String linea;

			while (sc.hasNextLine()) {
				linea = sc.nextLine();
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.err.println("No se ha podido leer el fichero");
		}
	}

}
