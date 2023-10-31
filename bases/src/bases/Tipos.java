package bases;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Clase Tipos para demostrar los diferentes tipos de datos de Java
 */
public class Tipos {
	/**
	 * Método al que llama la máquina virtual de Java
	 * @param args Se reciben los argumentos de consola
	 */
	public static void main(String[] args) {
		/*
		 * Crearemos unos cuantos tipos de datos para demostrar
		 * cómo se hacen las declaraciones en Java
		 */
		
		int x = 1, y = 2; // Declaración de una variable entera
		
		int z = x + y;
		
		System.out.println(z);
		
		long l = 12341231231L;
		
		System.out.println(l);
		
		double a = 1.1, b = 2.2;
		
		double c = a + b;
		
		System.out.println(c);
		
//		short s = null; // No se puede asignar valor null a un tipo primitivo
		Short s = null;
		
		s = 5;
		
		System.out.println(s);
		
		BigDecimal bda = new BigDecimal("1.1");
		BigDecimal bdb = new BigDecimal("2.2");
		
		BigDecimal bdc = bda.add(bdb);
		
		System.out.println(bdc);
		
		String texto = "Prueba";
		
		System.out.println(texto);
		
		System.out.println(texto.toUpperCase());
		
		System.out.println(texto.length());
		
		System.out.println(texto.replace("ba", "bas"));
		
		System.out.println(Math.sqrt(16));
		
		System.out.println(Math.pow(2, 3));
		
		LocalDate ld = LocalDate.of(2000, 1, 31);
		
		System.out.println(ld);
		
		System.out.println(ld.plusMonths(1));
	}
}
