package com.biblioteca.repositorios;

import java.util.Optional;
import java.util.function.Function;

import com.biblioteca.entidades.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonaJpaRepositorio implements PersonaRepositorio {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.biblioteca.entidades");
	
	@SuppressWarnings("unchecked")
	@Override
	public Optional<Persona> obtenerPorEmail(String email) {
		return (Optional<Persona>) transaccion(em -> em.createQuery("from Persona p where p.email = ?1").setParameter(1, email).getSingleResult());
	}

	private Object transaccion(Function<EntityManager, Object> funcion) {
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
