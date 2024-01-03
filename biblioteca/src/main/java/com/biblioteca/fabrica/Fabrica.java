package com.biblioteca.fabrica;

public interface Fabrica {
	public final static Fabrica fabrica = new FabricaImpl(); 
	
	<T> T obtenerObjeto(Class<T> tipo);
}
