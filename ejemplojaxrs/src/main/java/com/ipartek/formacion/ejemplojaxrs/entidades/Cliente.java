package com.ipartek.formacion.ejemplojaxrs.entidades;

import com.ipartek.formacion.ejemplojaxrs.bibliotecas.DniValido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@DniValido
	@Column(columnDefinition = "CHAR(9)", unique = true)
	private String dni;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Size(min = 2, max = 100)
	private String apellidos;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String direccion;
	
	@Pattern(regexp = "^\\d{9}$", message = "debe tener un formato de 9 dígitos")
	@Column(unique = true, columnDefinition = "CHAR(9)")
	private String telefono;
	
	@Pattern(regexp = "^\\d{5}$", message = "debe tener un formato de 5 dígitos")
	@Column(name = "codigo_postal", columnDefinition = "CHAR(5)")
	private String codigoPostal;
}
