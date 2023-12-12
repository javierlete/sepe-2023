package com.ipartek.formacion.ejemplojaxrs.servicios;

import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoUsuario;

public class LoginServicioImpl implements LoginServicio {

	private final DaoUsuario dao;
	
	public LoginServicioImpl(DaoUsuario dao) {
		this.dao = dao;
	}
	
	@Override
	public Usuario validarUsuario(String email, String password) {
		Usuario usuario = dao.buscarPorEmail(email);
		
		if(usuario == null) {
			return null;
		}
		
		if(!usuario.getPassword().equals(password)) {
			return null;
		}
		
		return usuario;
	}

}
