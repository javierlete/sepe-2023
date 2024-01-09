package com.ipartek.bibliotecaspring.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Email
	@Column(length = 50)
	@Size(max = 50)
	private String email;
	
	@NotNull
	@Column(length = 50)
	@Size(max = 50)
	private String password;

	@Column(length = 50)
	@Size(max = 50)
	private String nombre;
	
	@Pattern(regexp = "[XYZ\\d]\\{7}[A-Za-z]")
	@Column(columnDefinition = "CHAR(9)")
	private String dni;
	
	@Column(length = 20)
	@Size(max = 20)
	private String rol;
	
	@OneToMany(mappedBy = "prestatario")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Libro> libros;
}
