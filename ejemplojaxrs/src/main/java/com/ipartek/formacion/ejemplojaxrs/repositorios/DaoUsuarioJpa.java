package com.ipartek.formacion.ejemplojaxrs.repositorios;

import java.util.Collection;
import java.util.function.Function;

import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoUsuarioJpa implements DaoUsuario {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ejemplojaxrs.entidades");

	// Para contentar a nuestra fábrica que llama al constructor con cuatro
	// argumentos de tipo string
	public DaoUsuarioJpa(String ignorado1, String ignorado2, String ignorado3, String ignorado4) {
	}

	public DaoUsuarioJpa() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Usuario> obtenerTodos() {
		return (Collection<Usuario>) transaccion(em -> em.createQuery("from Usuario u join fetch u.rol", Usuario.class).getResultList());
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return (Usuario) transaccion(em -> em.find(Usuario.class, id));
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		return (Usuario) transaccion(em -> {
			usuario.setId(null);
			em.persist(usuario);
			return usuario;
		});
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		return (Usuario) transaccion(em -> {
			em.merge(usuario);
			return usuario;
		});
	}

	@Override
	public void borrar(Long id) {
		transaccion(em -> {
			em.remove(em.find(Usuario.class, id));
			// em.createQuery("delete from Cliente c where c.id = ?1").setParameter(1, id);
			return null;
		});
	}

	@Override
	public void borrar() {
		transaccion(em -> {
			em.createQuery("delete from Usuario");
			return null;
		});
	}

	@Override
	public int tamano() {
		return (int) transaccion(em -> em.createQuery("select count(u) from Usuario u").getSingleResult());
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

	@Override
	public Usuario buscarPorEmail(String email) {
		return (Usuario) transaccion(em -> em.createQuery("from Usuario u join fetch u.rol where u.email = ?1", Usuario.class).setParameter(1, email).getSingleResult());		
	}
}
