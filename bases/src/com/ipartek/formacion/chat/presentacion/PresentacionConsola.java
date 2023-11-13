package com.ipartek.formacion.chat.presentacion;

import static com.ipartek.formacion.bibliotecas.Consola.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.negocio.UsuarioNegocio;
import com.ipartek.formacion.chat.negocio.UsuarioNegocioImpl;
import com.ipartek.formacion.chat.pojos.Usuario;

public class PresentacionConsola {
	private static final UsuarioNegocio un = new UsuarioNegocioImpl();

	private static final int SALIR = 0;

	static {
		DaoUsuario dao = new DaoUsuarioMemoria();
		
		dao.insertar(new Usuario("Prueba1"));
		dao.insertar(new Usuario("Prueba2"));
	}
	
	public static void main(String[] args) {
		Logger.getLogger(UsuarioNegocioImpl.class.getName()).setLevel(Level.WARNING);
		
		int opcion;

		do {
			menu();
			opcion = obtenerOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void menu() {
		pl("1. LISTADO");
		pl("2. BUSCAR POR ID");
		pl("0. SALIR");
	}

	private static int obtenerOpcion() {
		return rInt("Elige una opción");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			datosUsuario();
			break;
		case 0:
			salir();
			break;
		}
	}

	private static void listado() {
		for (Usuario u : un.listado()) {
			mostrarUsuarioListado(u);
		}
	}

	private static void mostrarUsuarioListado(Usuario usuario) {
		// TODO cambiar el formato
		pl(usuario);
	}

	private static void datosUsuario() {
		Long id = rLong("Dime el id del usuario");

		Usuario usuario = un.datosUsuario(id);

		mostrarDatosUsuarioFicha(usuario);
	}

	private static void mostrarDatosUsuarioFicha(Usuario usuario) {
		// TODO usar un formato tipo ficha
		pl(usuario);
	}

	private static void salir() {
		pl("Saliendo del programa");
	}
}
