package bases;

import java.time.LocalDate;

public class Conversiones {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String texto = "56";
		
		int entero = Integer.parseInt(texto);
		
		double doble = Double.parseDouble(texto);
		
		System.out.println(entero + 1);
		System.out.println(doble);
		
		texto = "si";
		
		char caracter = texto.trim().charAt(0);
		
		System.out.println(caracter);
		
		boolean booleano = "si".equals(texto);
		
		System.out.println(booleano);
		
		texto = String.valueOf(doble);
		
		System.out.println(texto + 1);
		
		Double d = doble; // new Double(doble)
		
		double dd = d; // d.doubleValue()
		
		LocalDate hoy = LocalDate.now();
		
		String textoFecha = hoy.toString();
		
		System.out.println(textoFecha);
		
		LocalDate otraFecha = LocalDate.parse(textoFecha);
		
		System.out.println(otraFecha);
	}

}
