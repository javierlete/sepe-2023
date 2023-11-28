package com.ipartek.formacion.chat.negocio;

import com.ipartek.formacion.chat.pojos.Usuario;

public interface UsuarioNegocio {
	Iterable<Usuario> listado();
	Usuario detalle(Long id);
	Usuario crear(Usuario usuario);
	Usuario cambiar(Usuario usuario);
	void eliminar(Long id);
}
