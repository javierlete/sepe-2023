package com.ipartek.formacion.ejemplojaxrs.servicios;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;

public interface ClienteServicio {
	Iterable<Cliente> obtenerClientes();
}
