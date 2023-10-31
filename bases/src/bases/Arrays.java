package bases;

public class Arrays {
	public static void main(String[] args) {
		int[] arr = new int[3];
		
		arr[0] = 5;
		arr[1] = 6;
		arr[2] = 7;
//		arr[3] = 8; // Da una excepción (error en tiempo real)
		
		System.out.println(arr[1]);
		
		System.out.println(arr.length);
		
		for(int dato: arr) {
			System.out.print(dato + " ");
		}
		
		System.out.println();
		
		char[][] tablero = new char[3][4];
		
		tablero[0][0] = 'X';
		tablero[2][1] = 'O';
		
		System.out.println(tablero.length);
		System.out.println(tablero[0].length);
		
		for(char[] fila: tablero) {
			for(char casilla: fila) {
				System.out.print(casilla);
			}
			System.out.println();
		}
	}
}
