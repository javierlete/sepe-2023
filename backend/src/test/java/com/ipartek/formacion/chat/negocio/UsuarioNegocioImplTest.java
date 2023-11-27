package com.ipartek.formacion.chat.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.pojos.Usuario;

class UsuarioNegocioImplTest {
	private static final Usuario DOS = new Usuario("Dos");
	private static final Usuario UNO = new Usuario("Uno");
	
	private static final UsuarioNegocio un = new UsuarioNegocioImpl();
	
	static DaoUsuario dao = new DaoUsuarioMemoria();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		dao.insertar(UNO);
		dao.insertar(DOS);
	}

	@AfterEach
	void tearDown() throws Exception {
		dao.borrar();
	}

	@Test
	void testListado() {
		Iterable<Usuario> usuarios = un.listado();
		
		Iterator<Usuario> usuariosIterator = usuarios.iterator();
		
		assertTrue(usuariosIterator.hasNext());
		
		assertEquals(UNO, usuariosIterator.next());
		
		assertTrue(usuariosIterator.hasNext());
		
		assertEquals(DOS, usuariosIterator.next());
		
		assertFalse(usuariosIterator.hasNext());
	}

	@Test
	void testDatosUsuario() {
		Usuario usuario = un.datosUsuario(2L);
		
		assertNotNull(usuario);
		assertEquals(DOS, usuario);
		
		usuario = un.datosUsuario(5L);
		
		assertNull(usuario);
	}

}
