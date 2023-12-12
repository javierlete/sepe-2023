package com.ipartek.formacion.ejemplojaxrs.entidades;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
	@Min(0)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	private String nombre;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	private String password;
	
	@NotNull
	private Rol rol;
}
