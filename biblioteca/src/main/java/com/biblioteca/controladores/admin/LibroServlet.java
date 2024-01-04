package com.biblioteca.controladores.admin;

import java.io.IOException;

import com.biblioteca.entidades.Libro;
import com.biblioteca.servicios.UsuarioServicioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/libro")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String borrar = request.getParameter("borrar");

		Long id = Long.parseLong(sId);

		if (borrar != null) {
			// TODO borrado de elemento
			return;
		}

		var libro = new UsuarioServicioImpl().verLibroBiblioteca(id);

		request.setAttribute("libro", libro);

		request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String isbn = request.getParameter("isbn");
		String genero = request.getParameter("genero");
		String autor = request.getParameter("autor");
		String sUnidades = request.getParameter("unidades");
//		String prestatario = request.getParameter("prestatario");

		Long id;

		if (sId.isBlank()) {
			id = null;
		} else {
			id = Long.parseLong(sId);
		}
		
		Integer unidades = Integer.parseInt(sUnidades);

		Libro libro = Libro.builder().id(id).titulo(titulo).descripcion(descripcion).autor(autor).genero(genero)
				.isbn(isbn).unidades(unidades).prestatario(null).build();

		System.out.println(libro);
	}

}
