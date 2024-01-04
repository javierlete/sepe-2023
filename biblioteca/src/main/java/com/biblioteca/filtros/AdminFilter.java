package com.biblioteca.filtros;

import java.io.IOException;

import com.biblioteca.entidades.Persona;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		Persona usuario = (Persona) session.getAttribute("usuario");
		
		if(usuario == null || !usuario.getRol().equals("ADMIN")) {
			req.setAttribute("alerta", "El usuario debe estar logueado y ser administrador para entrar en esta parte de la web");
			req.setAttribute("nivel", "danger");
			
			req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, res);
			return;
		}
		
		chain.doFilter(request, response);
	}
}
