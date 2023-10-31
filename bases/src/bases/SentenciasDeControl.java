package bases;

public class SentenciasDeControl {

	public static void main(String[] args) {
		int dias, mes = 2;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4, 6, 9, 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}
		
		System.out.println("El mes " + mes + " tiene " + dias + " días");

		System.out.println(String.format("El mes %s tiene %s días", mes, dias));
		
		int c1 = 1;
		
		while(c1 <= 10) {
			System.out.print(c1 + " ");
			c1++;
		}
		
		System.out.println();
		
		for(int c2 = 1; c2 <= 10; c2++) {
			System.out.print(c2 + " ");
		}
		
		System.out.println();
		
		int[] arr = { 1, 5, 7, 8, 9, 7, 5, 34, 2 ,5 };
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		for(int i: arr) {
			System.out.print(i + " ");
		}
	}
}
