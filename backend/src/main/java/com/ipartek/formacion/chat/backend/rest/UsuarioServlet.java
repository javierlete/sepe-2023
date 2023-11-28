package com.ipartek.formacion.chat.backend.rest;

import java.io.IOException;
import java.io.PrintWriter;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.negocio.UsuarioNegocio;
import com.ipartek.formacion.chat.negocio.UsuarioNegocioImpl;
import com.ipartek.formacion.chat.pojos.Usuario;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/usuarios/*")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Jsonb jb = JsonbBuilder.create();
	private static final UsuarioNegocio un = new UsuarioNegocioImpl();

	static {
		DaoUsuario dao = new DaoUsuarioMemoria();
		dao.insertar(new Usuario("Uno"));
		dao.insertar(new Usuario("Dos"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Long id = obtenerId(request);

		if (id != null) {
			Usuario usuario = un.detalle(id);

			if(usuario == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			String json = jb.toJson(usuario);
			out.println(json);
			return;
		}

		Iterable<Usuario> usuarios = un.listado();

		String json = jb.toJson(usuarios);
		out.println(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = jb.fromJson(request.getReader(), Usuario.class);

		Usuario resultado = un.crear(usuario);

		response.setStatus(HttpServletResponse.SC_CREATED);
		response.getWriter().append(jb.toJson(resultado));
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);

		if (id != null) {

			Usuario usuario = jb.fromJson(request.getReader(), Usuario.class);

			Usuario resultado = un.cambiar(usuario);

			response.getWriter().append(jb.toJson(resultado));
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);

		un.eliminar(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	private static Long obtenerId(HttpServletRequest request) {
		String ruta = request.getPathInfo();

		if (ruta != null) {
			return Long.parseLong(ruta.substring(1));
		} else {
			return null;
		}
	}
}
