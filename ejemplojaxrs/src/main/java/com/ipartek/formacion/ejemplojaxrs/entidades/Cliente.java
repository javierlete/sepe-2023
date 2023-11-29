package com.ipartek.formacion.ejemplojaxrs.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
	private Long id;
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String codigoPostal;
}
