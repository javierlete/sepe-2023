package com.ipartek.formacion.ejemplojaxrs.rest.api2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.global.Globales;
import com.ipartek.formacion.ejemplojaxrs.servicios.ClienteServicio;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
	private static final ClienteServicio servicio = Globales.FABRICA.getServicioCliente();

	private static final Validator validador = Globales.FABRICA.getValidator();
	
	@GET
	public Collection<Cliente> listadoCompleto() {
		return servicio.obtenerClientes();
	}

	@GET
	@Path("{id}")
	public Cliente detalle(@PathParam("id") Long id) {
		Cliente cliente = servicio.obtenerClientePorId(id);

		if (cliente == null) {
			throw new NotFoundException();
		}

		return cliente;
	}

	@GET
	@Path("/busquedas/dni")
	public Response dni(@QueryParam("dni") String dni) {
		Cliente cliente = servicio.obtenerClientePorDni(dni);

		if (cliente == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.status(Status.OK).entity(cliente).build();
	}
	
	@POST
	public Response nuevoCliente(Cliente cliente) {
		var errores = validacionAErrores(cliente);
		
		if(errores.size() > 0) {
			return Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		
		return Response.status(Status.CREATED).entity(servicio.crearCliente(cliente)).build();
	}

	private HashMap<String, String> validacionAErrores(Cliente cliente) {
		Set<ConstraintViolation<Cliente>> fallosDeValidacion = validador.validate(cliente);
		
		var errores = new HashMap<String, String>();
		
		fallosDeValidacion.stream().forEach(fallo -> errores.put(fallo.getPropertyPath().toString(), fallo.getMessage()));
		return errores;
	}
	
	@PUT
	@Path("{id}")
	public Response modificarCliente(@PathParam("id") Long id, Cliente cliente) {
		var errores = validacionAErrores(cliente);
		
		if(errores.size() > 0) {
			return Response.status(Status.BAD_REQUEST).entity(errores).build();
		}
		
		return Response.status(Status.OK).entity(servicio.modificarCliente(cliente)).build();
	}
	
	
	@DELETE
	@Path("{id}")
	public void borrarCliente(@PathParam("id") Long id) {
		servicio.eliminarCliente(id);
	}
}
