package com.ipartek.formacion.bibliotecas;

import java.util.TreeMap;

public class TablaMemoria<T extends LongId> extends TreeMap<Long, T> {
	public Iterable<T> select() {
		return values();
	}
	
	public T select(Long id) {
		return get(id);
	}
	
	public T insert(T objeto) {
		Long id = size() > 0 ? lastKey() + 1L: 1L;
		objeto.setId(id);
		put(id, objeto);
		
		return objeto;
	}
	
	public T update(T objeto) {
		put(objeto.getId(), objeto);
		
		return objeto;
	}
	
	public void delete(Long id) {
		remove(id);
	}
	
	private static final long serialVersionUID = 7447723299049213253L;
}
