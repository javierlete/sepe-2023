package com.biblioteca.entidades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Libro {
	private Long id;
	private String titulo;
	private String descripcion;
	private String isbn;
	private Integer unidades;
	private String genero;
	private String autor;
}
