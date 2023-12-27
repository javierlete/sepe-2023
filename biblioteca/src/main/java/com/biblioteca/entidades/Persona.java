package com.biblioteca.entidades;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
	private Long id;
	private String email;
	private String password;
	private String nombre;
	private String dni;
	private String rol;
	
	private Set<Libro> libros;
}
