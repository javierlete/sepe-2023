package bases.interfaces;

public class InterfacesPrueba {

	public static void main(String[] args) {
		Rodable[] rodables = new Rodable[2];
		
		rodables[0] = new Balon();
		rodables[1] = new Naranja();
		
		for(Rodable r: rodables) {
			if(r instanceof Comestible c) {
				c.comer();
			}
			r.rodar();
			if(r instanceof Comestible c) {
				c.comer();
			}
		}
	}

}
