package bases;

public class Operadores {

	public static void main(String[] args) {
		System.out.println(6 ^ 3);
		System.out.println(6 & 3);
		System.out.println(6 | 3);
		System.out.println(~6);
		
		boolean b = false;
		
		System.out.println(b ? "VERDADERO" : "FALSO");
		
		int x = 8, y = 6;
		
		System.out.println(x > y ? x : y);
		
		System.out.println(x++);
		System.out.println(x);
		
		System.out.println(++y);
		System.out.println(y);
	}
}
