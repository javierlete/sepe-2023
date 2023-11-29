package com.ipartek.formacion.ejemplojaxrs.bibliotecas;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DniValidator implements ConstraintValidator<DniValido, String> {

	private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	private static final String REGEXP = "^[XYZ\\d]\\d{7}[" + LETRAS + "]$";

	@Override
	public boolean isValid(String dni, ConstraintValidatorContext context) {
		if (!dni.matches(REGEXP)) {
			return false;
		}

		String sNumero = dni.substring(0, 8);
		char letra = dni.charAt(8);

		sNumero = sNumero.replace('X', '0').replace('Y', '1').replace('Z', '2');

		int numero = Integer.parseInt(sNumero);

		char letraCalculada = LETRAS.charAt(numero % 23);
		
		return letra == letraCalculada;
	}

}
