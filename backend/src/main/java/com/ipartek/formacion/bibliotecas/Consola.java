package com.ipartek.formacion.bibliotecas;

import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);
	
	public static void pl(Object o) {
		System.out.println(o);
	}

	public static void pl() {
		System.out.println();
	}

	public static void p(Object o) {
		System.out.print(o);
	}
	
	public static String rString(String mensaje) {
		p(mensaje + ": ");
		return SC.nextLine();
	}
	
	public static int rInt(String mensaje) {
		String linea;
		
		int i = 0;
		boolean hayError = true;
		
		do {
			try {
				linea = rString(mensaje);
				i = Integer.parseInt(linea);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("El dato introducido no es un entero");
			} 
		} while (hayError);
		
		return i;
	}
	
	public static Long rLong(String mensaje) {
		String linea;
		
		long l = 0;
		boolean hayError = true;
		
		do {
			try {
				linea = rString(mensaje);
				l = Long.parseLong(linea);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("El dato introducido no es un entero");
			} 
		} while (hayError);
		
		return l;
	}
}
