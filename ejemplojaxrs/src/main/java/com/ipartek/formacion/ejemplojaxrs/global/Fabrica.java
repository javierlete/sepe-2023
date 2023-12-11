package com.ipartek.formacion.ejemplojaxrs.global;

import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoCliente;
import com.ipartek.formacion.ejemplojaxrs.servicios.ClienteServicio;

import jakarta.validation.Validator;

public interface Fabrica {
	ClienteServicio getServicioCliente();
	DaoCliente getDaoCliente();
	Validator getValidator();
}
