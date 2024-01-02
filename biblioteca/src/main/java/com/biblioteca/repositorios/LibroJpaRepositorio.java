package com.biblioteca.repositorios;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import com.biblioteca.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LibroJpaRepositorio implements LibroRepositorio {
	

	@SuppressWarnings("unchecked")
	@Override
	public Set<Libro> obtenerTodos() {
		var libros = transaccion(em -> em.createQuery("from Libro").getResultList());
		return new HashSet<Libro>((Collection<Libro>) libros);
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return (Libro) transaccion(em -> em.find(Libro.class, id));
	}

	private Object transaccion(Function<EntityManager, Object> funcion) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.biblioteca.entidades");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Object resultado = funcion.apply(entityManager);
			transaction.commit();
			return resultado;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}
}
