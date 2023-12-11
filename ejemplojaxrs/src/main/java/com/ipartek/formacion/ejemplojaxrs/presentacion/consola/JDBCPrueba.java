package com.ipartek.formacion.ejemplojaxrs.presentacion.consola;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.global.Globales;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoCliente;

public class JDBCPrueba {
	public static void main(String[] args) {
		DaoCliente dao = Globales.FABRICA.getDaoCliente();
		
		for(Cliente c: dao.obtenerTodos()) {
			System.out.println(c);
		}
	}
}
