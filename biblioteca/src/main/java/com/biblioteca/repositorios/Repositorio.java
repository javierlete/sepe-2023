package com.biblioteca.repositorios;

import java.util.Set;

public interface Repositorio<T> {
	default Set<T> obtenerTodos() {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	default T obtenerPorId(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	default T insertar(T objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	default T modificar(T objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	default T borrar(T objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}
}
