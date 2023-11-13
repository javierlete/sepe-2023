package com.ipartek.formacion.chat.negocio;

import com.ipartek.formacion.chat.pojos.Usuario;

public interface UsuarioNegocio {
	Iterable<Usuario> listado();
	Usuario datosUsuario(Long id);
}
