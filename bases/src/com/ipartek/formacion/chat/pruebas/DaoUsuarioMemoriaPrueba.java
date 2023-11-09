package com.ipartek.formacion.chat.pruebas;

import java.time.LocalDateTime;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.pojos.Usuario;

public class DaoUsuarioMemoriaPrueba {

	public static void main(String[] args) {
		DaoUsuario dao = new DaoUsuarioMemoria();

		dao.insertar(new Usuario("Uno"));
		dao.insertar(new Usuario("Dos"));
		dao.insertar(new Usuario("Tres"));
		dao.insertar(new Usuario("Cuatro", LocalDateTime.of(2023, 1, 1, 1, 1)));
		dao.insertar(new Usuario("Cuatro", LocalDateTime.of(2023, 3, 1, 1, 1)));

		dao.modificar(new Usuario(2L, "Dos Modificado", LocalDateTime.now()));

		dao.borrar(1L);

		Usuario usuarioAModificar = dao.obtenerPorId(3L);

		System.out.println("Usuario id 3");

		System.out.println(usuarioAModificar);

		usuarioAModificar.setNombre("Modificado");

		dao.modificar(usuarioAModificar);

		System.out.println("Listado completo");

		for (Usuario u : dao.obtenerTodos()) {
			System.out.println(u);
		}

		String textoABuscar = "os";

		System.out.println("Buscando " + textoABuscar);

		for (Usuario u : dao.buscarPorNombre(textoABuscar)) {
			System.out.println(u);
		}

		LocalDateTime fecha = LocalDateTime.of(2023, 5, 5, 0, 0);

		System.out.println("Buscando posteriores a " + fecha);

		for (Usuario u : dao.buscarPorUltimaConexion(fecha)) {
			System.out.println(u);
		}

		LocalDateTime fechaInicio = LocalDateTime.of(2023, 2, 2, 0, 0);
		LocalDateTime fechaFin = LocalDateTime.of(2023, 4, 4, 0, 0);
		
		System.out.println("Buscando posteriores a " + fechaInicio + " y anteriores a " + fechaFin);

		for (Usuario u : dao.buscarPorRangoDeFechas(fechaInicio, fechaFin)) {
			System.out.println(u);
		}
	}
}
