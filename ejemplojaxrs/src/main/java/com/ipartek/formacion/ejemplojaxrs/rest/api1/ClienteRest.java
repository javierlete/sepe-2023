package com.ipartek.formacion.ejemplojaxrs.rest.api1;

import java.io.IOException;

import com.ipartek.formacion.ejemplojaxrs.global.Globales;
import com.ipartek.formacion.ejemplojaxrs.servicios.ClienteServicio;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/clientes/*")
public class ClienteRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Jsonb jb = JsonbBuilder.create();
	private static final ClienteServicio servicio = Globales.FABRICA.getServicioCliente();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().append(jb.toJson(servicio.obtenerClientes()));
	}

}
