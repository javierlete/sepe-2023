package com.ipartek.formacion.ejemplojaxrs.servicios;

import java.util.Collection;
import java.util.logging.Logger;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoCliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoClienteMemoria;

public class ClienteServicioImpl implements ClienteServicio {

	private static final Logger log = Logger.getLogger(ClienteServicioImpl.class.getName());
	private static final DaoCliente dao = new DaoClienteMemoria();
	
	@Override
	public Collection<Cliente> obtenerClientes() {
		return dao.obtenerTodos();
	}

	@Override
	public Cliente obtenerClientePorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public Cliente obtenerClientePorDni(String dni) {
		log.info(dni);
		return dao.obtenerPorDni(dni);
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
		return dao.insertar(cliente);
	}

	@Override
	public Cliente modificarCliente(Cliente cliente) {
		return dao.modificar(cliente);
	}

	@Override
	public void eliminarCliente(Long id) {
		dao.borrar(id);
	}

}
