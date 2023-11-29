package com.ipartek.formacion.ejemplojaxrs.presentacion.consola;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente.ClienteBuilder;

public class DemoBuilder {
	public static void main(String[] args) {
		ClienteBuilder cb = Cliente.builder();
		
		cb.id(1L).nombre("Javier").apellidos("Lete");
		
		cb.direccion("Su casa").codigoPostal("12345");
		
		cb.dni("12345678Z").telefono("912345678");
		
		Cliente c = cb.build();
		
		System.out.println(c);
	}
}
