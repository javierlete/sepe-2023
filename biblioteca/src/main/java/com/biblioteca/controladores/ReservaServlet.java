package com.biblioteca.controladores;

import java.io.IOException;

import com.biblioteca.entidades.Persona;
import com.biblioteca.servicios.UsuarioServicioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reserva")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		Long id = Long.parseLong(sId);
		
		var libro = new UsuarioServicioImpl().verLibroBiblioteca(id);
		
		request.setAttribute("libro", libro);
		
		Persona usuario = (Persona) request.getSession().getAttribute("usuario");
		
		new UsuarioServicioImpl().agregarPrestamo(usuario, libro);
		
		request.getRequestDispatcher("/WEB-INF/vistas/confirmacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
