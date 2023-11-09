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
		
		dao.modificar(new Usuario(2L, "Dos Modificado", LocalDateTime.now()));
		
		dao.borrar(1L);
		
		Usuario usuarioAModificar = dao.obtenerPorId(3L);
		
		System.out.println(usuarioAModificar);
		
		usuarioAModificar.setNombre("Modificado");
		
		dao.modificar(usuarioAModificar);
		
		for(Usuario u: dao.obtenerTodos()) {
			System.out.println(u);
		}
	}

}
