package bases.interfaces;

public class Naranja extends Fruto implements Comestible, Rodable {
	private boolean porElSuelo = false;
	
	public void rodar() {
		porElSuelo = true;
		
		System.out.println("Naranja rodando");
	}

	public void comer() {
		if(porElSuelo) {
			System.out.println("¡PUAGH, QUE ASCO!");
		} else {
			System.out.println("Ñam, que rica");
		}
	}

}
