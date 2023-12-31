package com.ipartek.formacion.chat.accesodatos;

public interface Dao<T> {
	public Iterable<T> obtenerTodos();
	public T obtenerPorId(Long id);
	
	public T insertar(T objeto);
	public T modificar(T objeto);
	public void borrar(Long id);
	public void borrar();
	
	public int tamano();
}
