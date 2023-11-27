package com.ipartek.formacion.chat.accesodatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.chat.pojos.Usuario;

class DaoUsuarioMemoriaTest {

	private static final Usuario UNO = new Usuario("Uno", LocalDateTime.of(2023, 1, 1, 0, 0));
	private static final Usuario DOS = new Usuario("Dos", LocalDateTime.of(2023, 2, 1, 0, 0));

	private static final Usuario TRES = new Usuario("Tres", LocalDateTime.of(2023, 3, 1, 0, 0));

	static DaoUsuario dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new DaoUsuarioMemoria();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		DaoUsuarioMemoria.usuarios.insert(UNO);
		DaoUsuarioMemoria.usuarios.insert(DOS);
	}

	@AfterEach
	void tearDown() throws Exception {
		DaoUsuarioMemoria.usuarios.clear();
	}

	@Test
	void testObtenerTodos() {
		Iterable<Usuario> usuarios = dao.obtenerTodos();

		Iterator<Usuario> iterador = usuarios.iterator();

		assertTrue(iterador.hasNext());

		Usuario usuario = iterador.next();
		assertEquals(UNO, usuario);

		assertTrue(iterador.hasNext());

		usuario = iterador.next();
		assertEquals(DOS, usuario);

		assertFalse(iterador.hasNext());
	}

	@Test
	void testObtenerPorId() {
		Usuario usuario = dao.obtenerPorId(1L);

		assertNotNull(usuario);
		assertEquals(UNO, usuario);

		usuario = dao.obtenerPorId(5L);

		assertNull(usuario);
	}

	@Test
	void testInsertar() {
		Usuario usuario = dao.insertar(TRES);

		assertNotNull(usuario);
		assertEquals(3, DaoUsuarioMemoria.usuarios.size());

		assertEquals(TRES, usuario);
	}

	@Test
	void testModificar() {
		Usuario usuarioAModificar = new Usuario(2L, "Modificado", LocalDateTime.now());

		Usuario recibido = dao.modificar(usuarioAModificar);

		assertEquals(usuarioAModificar, recibido);

		Usuario colocado = DaoUsuarioMemoria.usuarios.get(usuarioAModificar.getId());

		assertEquals(usuarioAModificar, colocado);
	}

	@Test
	void testBorrar() {
		dao.borrar(2L);

		assertEquals(1, DaoUsuarioMemoria.usuarios.size());
	}

	@Test
	void testBuscarPorNombre() {
		Iterable<Usuario> usuarios = dao.buscarPorNombre("os");

		Iterator<Usuario> iterador = usuarios.iterator();

		assertTrue(iterador.hasNext());

		Usuario usuario = iterador.next();

		assertEquals(DOS, usuario);

		assertFalse(iterador.hasNext());
	}

	@Test
	void testBuscarPorUltimaConexion() {
		Iterable<Usuario> usuarios = dao.buscarPorUltimaConexion(LocalDateTime.of(2023, 1, 15, 0, 0));

		Iterator<Usuario> iterador = usuarios.iterator();

		assertTrue(iterador.hasNext());

		Usuario usuario = iterador.next();

		assertEquals(DOS, usuario);

		assertFalse(iterador.hasNext());
	}

	@Test
	void testBuscarPorRangoDeFechas() {
		Iterable<Usuario> usuarios = dao.buscarPorRangoDeFechas(LocalDateTime.of(2022, 1, 1, 0, 0),
				LocalDateTime.of(2023, 1, 15, 0, 0));

		Iterator<Usuario> iterador = usuarios.iterator();

		assertTrue(iterador.hasNext());

		Usuario usuario = iterador.next();

		assertEquals(UNO, usuario);

		assertFalse(iterador.hasNext());
	}

}
