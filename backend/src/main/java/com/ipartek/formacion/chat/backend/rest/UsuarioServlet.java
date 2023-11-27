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
    
	static {
		DaoUsuario dao = new DaoUsuarioMemoria();
		dao.insertar(new Usuario("Uno"));
		dao.insertar(new Usuario("Dos"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioNegocio un = new UsuarioNegocioImpl();
		PrintWriter out = response.getWriter();
		Jsonb jb = JsonbBuilder.create();

		String ruta = request.getPathInfo();
		
		if(ruta != null) {
			Long id = Long.parseLong(ruta.substring(1));
			Usuario usuario = un.datosUsuario(id);
			
			String json = jb.toJson(usuario); 
			out.println(json);
			return;
		}
		
		Iterable<Usuario> usuarios = un.listado();
		
		String json = jb.toJson(usuarios);
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
