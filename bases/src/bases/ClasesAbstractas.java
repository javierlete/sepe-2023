package bases;

public class ClasesAbstractas {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		Number[] numeros = new Number[4];
		
		numeros[0] = new Integer(5);
		numeros[1] = 6;
		numeros[2] = new Double(1.2);
		numeros[3] = 7.8;
		
		for(Number n: numeros) {
			System.out.println(n.doubleValue());
		}
	}

}
