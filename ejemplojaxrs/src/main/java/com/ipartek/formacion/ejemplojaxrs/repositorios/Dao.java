package com.ipartek.formacion.ejemplojaxrs.repositorios;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}

	default T insertar(T objeto) {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}

	default T modificar(T objeto) {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}

	default void borrar() {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}

	default int tamano() {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}
}
