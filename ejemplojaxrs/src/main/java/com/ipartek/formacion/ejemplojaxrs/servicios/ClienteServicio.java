package com.ipartek.formacion.ejemplojaxrs.servicios;

import java.util.Collection;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;

public interface ClienteServicio {
	Collection<Cliente> obtenerClientes();
	Cliente obtenerClientePorId(Long id);
	Cliente obtenerClientePorDni(String dni);
	
	Cliente crearCliente(Cliente cliente);
	Cliente modificarCliente(Cliente cliente);
	void eliminarCliente(Long id);
}
