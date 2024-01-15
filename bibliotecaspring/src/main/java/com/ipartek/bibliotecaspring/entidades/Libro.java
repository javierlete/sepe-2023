package com.ipartek.bibliotecaspring.entidades;

import org.hibernate.validator.constraints.EAN;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(length = 50, nullable = false)
	@Size(max = 50)
	private String titulo;
	
	@Lob
	private String descripcion;
	
	@Column(length = 13)
	@Pattern(regexp = "^\\d{13}$")
	@Size(max = 13)
	@EAN
	private String isbn;
	
	@Min(0)
	private Integer unidades;
	
	@Column(length = 50)
	@Size(max = 50)
	private String genero;

	@Column(length = 50)
	@Size(max = 50)
	private String autor;
	
	@JsonIgnore
	@ManyToOne
	private Persona prestatario;
}
