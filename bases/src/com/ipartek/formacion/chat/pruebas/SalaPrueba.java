package com.ipartek.formacion.chat.pruebas;

import com.ipartek.formacion.chat.pojos.Mensaje;
import com.ipartek.formacion.chat.pojos.Sala;
import com.ipartek.formacion.chat.pojos.Usuario;

public class SalaPrueba {

	public static void main(String[] args) {
		Sala sala = new Sala(1L, "Principal");
		
		Usuario usuario = new Usuario("Javier");
		
		sala.addUsuario(usuario);
		sala.addMensaje(new Mensaje("Hola a todos", usuario));
		
		for(Usuario u: sala.getUsuarios()) {
			System.out.println(u);
		}
		
		for(Mensaje m: sala.getMensajes()) {
			System.out.println(m);
		}
	}

}
