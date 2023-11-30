package com.ipartek.formacion.ejemplojaxrs.repositorios;

import java.util.Collection;
import java.util.TreeMap;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;

public class DaoClienteMemoria implements DaoCliente {
	private static final TreeMap<Long, Cliente> clientes = new TreeMap<>();

	static {
		clientes.put(1L,
				Cliente.builder().id(1L).dni("12345678Z").nombre("Javier").direccion("Dirección de Javier").build());
		clientes.put(2L,
				Cliente.builder().id(2L).dni("87654321Z").nombre("Pepe").direccion("Dirección de Pepe").build());
		clientes.put(3L, new Cliente(3L, "87654321A", "Juan", "Pérez", "Su casa", "91234567", "12345"));
	}

	@Override
	public Collection<Cliente> obtenerTodos() {
		return clientes.values();
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return clientes.get(id);
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		Long id = clientes.size() > 0 ? clientes.lastKey() + 1L : 1L;

		cliente.setId(id);
		clientes.put(id, cliente);

		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		clientes.remove(id);
	}

	@Override
	public void borrar() {
		clientes.clear();
	}

	@Override
	public int tamano() {
		return clientes.size();
	}

	@Override
	public Cliente obtenerPorDni(String dni) {
		return clientes.values().stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
	}
}
