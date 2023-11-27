package com.ipartek.formacion.chat.negocio;

import java.util.logging.Logger;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.pojos.Usuario;

public class UsuarioNegocioImpl implements UsuarioNegocio {
	private static final Logger log = Logger.getLogger(UsuarioNegocioImpl.class.getName());
	
	private static final DaoUsuario dao = new DaoUsuarioMemoria();
	
	@Override
	public Iterable<Usuario> listado() {
		log.info("Se ha pedido el listado de usuarios");
		
		Iterable<Usuario> usuarios = dao.obtenerTodos();
		
		log.info("Se ha obtenido el listado de usuarios");
		
		return usuarios;
	}

	@Override
	public Usuario datosUsuario(Long id) {
		log.info("Se han pedido los datos del usuario " + id);
		
		Usuario usuario = dao.obtenerPorId(id);
		
		if(usuario != null) {
			log.info("Se ha encontrado correctamente el usuario");
			
			return usuario;
		} else {
			log.warning("No se ha encontrado el usuario");
			
			return null;
		}
	}
}
