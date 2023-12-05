package com.ipartek.formacion.ejemplojaxrs.presentacion.consola;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoCliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoClienteSqlite;

public class JDBCPrueba {
	public static void main(String[] args) {
		DaoCliente dao = new DaoClienteSqlite();
		
		for(Cliente c: dao.obtenerTodos()) {
			System.out.println(c);
		}
	}
}
