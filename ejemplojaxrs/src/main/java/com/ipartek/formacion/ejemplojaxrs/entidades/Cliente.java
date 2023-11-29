package com.ipartek.formacion.ejemplojaxrs.entidades;

import com.ipartek.formacion.ejemplojaxrs.bibliotecas.DniValido;

import jakarta.validation.constraints.Min;
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
public class Cliente {
	@Min(0)
	private Long id;
	
	@NotNull
	@DniValido
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
	private String telefono;
	
	@Pattern(regexp = "^\\d{5}$", message = "debe tener un formato de 5 dígitos")
	private String codigoPostal;
}
