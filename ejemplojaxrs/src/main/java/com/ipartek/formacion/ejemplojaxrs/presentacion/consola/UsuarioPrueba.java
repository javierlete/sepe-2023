package com.ipartek.formacion.ejemplojaxrs.presentacion.consola;

import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;
import com.ipartek.formacion.ejemplojaxrs.global.Globales;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoUsuario;
import com.ipartek.formacion.ejemplojaxrs.servicios.LoginServicio;

public class UsuarioPrueba {

	public static void main(String[] args) {
		DaoUsuario dao = Globales.FABRICA.getDaoUsuario();
		
		Usuario usuario = dao.buscarPorEmail("pepe@email.net");
		
		System.out.println(usuario);
		
		LoginServicio login = Globales.FABRICA.getServicioLogin();
		
		usuario = login.validarUsuario("javier@email.net", "javier");
		
		System.out.println(usuario);
		
		usuario = login.validarUsuario("juan@email.net", "juan");
		
		System.out.println(usuario);
		
		usuario = login.validarUsuario("juan@email.net", "jua");
		
		System.out.println(usuario);
	}
}
