package com.ipartek.formacion.ejemplojaxrs.repositorios;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;

public interface DaoCliente extends Dao<Cliente> {
	default Cliente obtenerPorDni(String dni) {
		throw new RepositoriosException("NO IMPLEMENTADO");
	}
}
