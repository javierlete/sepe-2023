package com.ipartek.formacion.ejemplojaxrs.presentacion.consola;

import com.ipartek.formacion.ejemplojaxrs.entidades.Rol;
import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaPrueba {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ejemplojaxrs.entidades");
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
	
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		Rol rol = em.find(Rol.class, 1L);
		Usuario usuario = Usuario.builder().nombre("Nuevo").email("nuevo@email.net").password("nuevo").rol(rol).build(); 
		
		em.persist(usuario);
		
		t.commit();
		
		t = em.getTransaction();
		t.begin();
		
		var usuarios = em.createQuery("from Usuario u join fetch u.rol", Usuario.class).getResultList();
		
		for(Usuario u: usuarios) {
			System.out.println(u);
		}
		
		t.commit();
	}

}
