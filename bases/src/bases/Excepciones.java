package bases;

public class Excepciones {

	@SuppressWarnings({ "unused", "null" })
	public static void main(String[] args) {
		int[] arr = new int[2];
		
		try {
			int i = Integer.parseInt("");
			
			String s = null;
			
			System.out.println(s.toUpperCase());
			
			arr[3] = 5;
		} catch(NullPointerException e) {
			System.out.println("PERO QUE PEAZO ANIMAL...");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nos hemos salido del array");
		} finally {
			System.out.println("Me ejecuto POR MIS NARICES");
		}
		
		System.out.println("Fin");
	}

}
