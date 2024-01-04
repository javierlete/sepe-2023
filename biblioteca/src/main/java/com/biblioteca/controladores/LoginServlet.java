package com.biblioteca.controladores;

import java.io.IOException;

import com.biblioteca.entidades.Persona;
import com.biblioteca.servicios.AnonimoServicioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger información de petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Convertir los datos
		// Crear objetos en base a los datos
		// Llamar a los servicios/lógica de negocio
		Persona persona = new AnonimoServicioImpl().iniciarSesion(email, password);
		
		if(persona == null) {
			// Empaquetar respuestas para la pantalla
			request.setAttribute("email", email);
			request.setAttribute("alerta", "El usuario o contraseña no son correctos");
			request.setAttribute("nivel", "danger");
			// Saltar a pantalla
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
			return;
		}

		// Empaquetar respuestas para la pantalla (en este caso en sesión para el resto de pantallas)
		request.getSession().setAttribute("usuario", persona);
		response.sendRedirect(request.getContextPath() + "/index");
	}

}
