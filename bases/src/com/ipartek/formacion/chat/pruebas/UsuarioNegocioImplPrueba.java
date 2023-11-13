package com.ipartek.formacion.chat.pruebas;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.negocio.UsuarioNegocio;
import com.ipartek.formacion.chat.negocio.UsuarioNegocioImpl;
import com.ipartek.formacion.chat.pojos.Usuario;

public class UsuarioNegocioImplPrueba {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(UsuarioNegocioImpl.class.getName());
		log.setLevel(Level.INFO);
		
		DaoUsuario dao = new DaoUsuarioMemoria();

		dao.insertar(new Usuario("Uno"));
		dao.insertar(new Usuario("Dos"));
		dao.insertar(new Usuario("Tres"));
		dao.insertar(new Usuario("Cuatro", LocalDateTime.of(2023, 1, 1, 1, 1)));

		UsuarioNegocio un = new UsuarioNegocioImpl();
		
		for(Usuario u: un.listado()) {
			System.out.println(u);
		}
		
		System.out.println(un.datosUsuario(10L));
		
		
	}

}
