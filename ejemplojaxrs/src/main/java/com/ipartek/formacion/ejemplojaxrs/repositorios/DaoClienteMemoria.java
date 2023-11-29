package com.ipartek.formacion.ejemplojaxrs.repositorios;

import java.util.Map;
import java.util.TreeMap;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;

public class DaoClienteMemoria implements DaoCliente {
	private static final Map<Long, Cliente> clientes = new TreeMap<>();
	
	static {
		clientes.put(1L, Cliente.builder().id(1L).dni("12345678Z").nombre("Javier").direccion("laksdjflkasdj").build());
		clientes.put(2L, Cliente.builder().id(2L).dni("87654321Z").nombre("Pepe").direccion("laksdjflkasdj").build());
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return clientes.values();
	}
	
	
}
