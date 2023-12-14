package com.ipartek.formacion.ejemplojaxrs.repositorios;

import java.util.Collection;
import java.util.function.Function;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoClienteJpa implements DaoCliente {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ejemplojaxrs.entidades");

	// Para contentar a nuestra fábrica que llama al constructor con cuatro
	// argumentos de tipo string
	public DaoClienteJpa(String ignorado1, String ignorado2, String ignorado3, String ignorado4) {
	}

	public DaoClienteJpa() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cliente> obtenerTodos() {
		return (Collection<Cliente>) transaccion(em -> em.createQuery("from Cliente", Cliente.class).getResultList());
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return (Cliente) transaccion(em -> em.find(Cliente.class, id));
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		return (Cliente) transaccion(em -> {
			cliente.setId(null);
			em.persist(cliente);
			return cliente;
		});
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		return (Cliente) transaccion(em -> {
			em.merge(cliente);
			return cliente;
		});
	}

	@Override
	public void borrar(Long id) {
		transaccion(em -> {
			em.remove(em.find(Cliente.class, id));
			// em.createQuery("delete from Cliente c where c.id = ?1").setParameter(1, id);
			return null;
		});
	}

	@Override
	public void borrar() {
		transaccion(em -> {
			em.createQuery("delete from Cliente");
			return null;
		});
	}

	@Override
	public int tamano() {
		return (int) transaccion(em -> em.createQuery("select count(c) from Cliente c").getSingleResult());
	}

	@Override
	public Cliente obtenerPorDni(String dni) {
		return (Cliente) transaccion(
				em -> em.createQuery("from Cliente c where c.dni = ?1").setParameter(1, dni).getSingleResult());
	}

	private Object transaccion(Function<EntityManager, Object> funcion) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
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
