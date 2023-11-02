package com.ipartek.formacion.pruebas;

import static com.ipartek.formacion.bibliotecas.Consola.*;

public class ConsolaPrueba {

	public static void main(String[] args) {
		pl("Prueba de consola");
		
		int numero = rInt("Dime un número");
		
		pl("Tu número es " + numero);
		
		String nombre = rString("Dime tu nombre");
		
		pl("Hola " + nombre);
	}

}
