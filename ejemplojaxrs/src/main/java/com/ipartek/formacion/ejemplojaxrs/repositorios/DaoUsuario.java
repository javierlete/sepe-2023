package com.ipartek.formacion.ejemplojaxrs.repositorios;

import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario>{
	Usuario buscarPorEmail(String email);
}
