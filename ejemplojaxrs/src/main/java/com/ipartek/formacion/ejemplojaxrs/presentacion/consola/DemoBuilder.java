package com.ipartek.formacion.ejemplojaxrs.presentacion.consola;

import java.util.Set;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente.ClienteBuilder;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class DemoBuilder {
	public static void main(String[] args) {
		ClienteBuilder cb = Cliente.builder();
		
		cb.id(5L).nombre("Javier").apellidos("Lete");
		
		cb.direccion("Su casa").codigoPostal("12345");
		
		cb.dni("12345678Z").telefono("123456789");
		
		Cliente c = cb.build();
		
		System.out.println(c);
		
		ValidatorFactory fabricaValidaciones = Validation.buildDefaultValidatorFactory();
		Validator validador = fabricaValidaciones.getValidator();
		
		Set<ConstraintViolation<Cliente>> fallosDeValidacion = validador.validate(c);
		
		for(ConstraintViolation<Cliente> fallo: fallosDeValidacion) {
//			System.out.println(fallo);
			System.out.println(fallo.getPropertyPath() + ": " + fallo.getMessage());
		}
		
		if(fallosDeValidacion.size() == 0) {
			System.out.println("No hay errores");
		}
	}
}
