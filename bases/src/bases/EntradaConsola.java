package bases;

import java.util.Scanner;

public class EntradaConsola {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime un número: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("El número introducido es " + numero);
		
		System.out.print("Dime un número: ");
		
		numero = Integer.parseInt(sc.nextLine());
		
		System.out.println("El número introducido es " + numero);

		System.out.print("Dime tu nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("Hola " + nombre);
		
		System.out.print("Dime tu nombre: ");
		nombre = sc.nextLine();
		
		System.out.println("Hola " + nombre);
		
		sc.close();
	}

}
