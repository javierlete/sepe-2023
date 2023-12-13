package com.ipartek.formacion.ejemplojaxrs.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rol {
	@Min(0)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Size(min = 10, max = 255)
	private String descripcion;
	
	@JsonbTransient
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private Set<Usuario> usuarios = new HashSet<>();
}
