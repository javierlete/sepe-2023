package com.ipartek.formacion.ejemplojaxrs.servicios;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoCliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoClienteMemoria;

public class ClienteServicioImpl implements ClienteServicio {

	private static final DaoCliente dao = new DaoClienteMemoria();
	
	@Override
	public Iterable<Cliente> obtenerClientes() {
		return dao.obtenerTodos();
	}

}
