package bases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Colecciones {
	public static void main(String[] args) {
		ejemploList();
		ejemploSet();
		ejemploMap();
	}
	
	public static void ejemploMap() {
		var diccionario = new HashMap<String, String>();
		
		diccionario.put("casa", "house");
		diccionario.put("perro", "dog");
		
		System.out.println(diccionario.get("perro"));
		
		for(Entry<String, String> par: diccionario.entrySet()) {
			System.out.printf("%s = %s\n", par.getKey(), par.getValue());
		}
		
		for(String clave: diccionario.keySet()) {
			System.out.printf("%s = %s\n", clave, diccionario.get(clave));
		}
		
		for(String valor: diccionario.values()) {
			System.out.println(valor);
		}
	}
	
	public static void ejemploSet() {
		var nombres = new HashSet<String>();
		
		nombres.add("Uno");
		nombres.add("Dos");
		nombres.add("Tres");
		
		nombres.remove("Dos");
		
//		nombres.add(0, "Cero");
		
		nombres.add("Tres");
		
		nombres.add(null);
		
		for(String nombre: nombres) {
			System.out.println(nombre);
		}
	}
	
	public static void ejemploList() {
		var nombres = new ArrayList<String>();
		
		nombres.add("Uno");
		nombres.add("Dos");
		nombres.add("Tres");
		
		nombres.remove(1);
		
		nombres.add(0, "Cero");
		
		nombres.add("Tres");
		
		nombres.add(null);
		
		for(String nombre: nombres) {
			System.out.println(nombre);
		}
	}
}
