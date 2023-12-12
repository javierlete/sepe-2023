package com.ipartek.formacion.ejemplojaxrs.global;

import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoCliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoUsuario;
import com.ipartek.formacion.ejemplojaxrs.servicios.ClienteServicio;
import com.ipartek.formacion.ejemplojaxrs.servicios.LoginServicio;

import jakarta.validation.Validator;

public interface Fabrica {
	ClienteServicio getServicioCliente();
	LoginServicio getServicioLogin();
	
	DaoCliente getDaoCliente();
	DaoUsuario getDaoUsuario();
	
	Validator getValidator();
}
