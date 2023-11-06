package com.ipartek.formacion.chat.pruebas;

import java.time.LocalDateTime;

import com.ipartek.formacion.chat.pojos.Usuario;

public class UsuarioPrueba {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		
		System.out.println(usuario);
		
//		System.out.printf("%s, %s, %s\n", usuario.getId(), usuario.getNombre(), usuario.getFechaUltimaConexion());
				
		usuario.setId(1L);
		usuario.setNombre("     Javier                ");
		usuario.setFechaUltimaConexion(LocalDateTime.now());
		
		System.out.println(usuario);
		
//		System.out.printf("%s, %s, %s\n", usuario.getId(), usuario.getNombre(), usuario.getFechaUltimaConexion());
		
		LocalDateTime fecha = LocalDateTime.of(2000, 1, 2, 1, 2, 3);
		Usuario javier = new Usuario(1L, "Javier", fecha);
		System.out.println(javier);
		
//		System.out.printf("%s, %s, %s\n", javier.getId(), javier.getNombre(), javier.getFechaUltimaConexion());
		
		usuario.setFechaUltimaConexion(fecha);
		
		System.out.println(usuario);
		System.out.println(javier);
		
		System.out.println("¿Son el mismo objeto? " + (usuario == javier)); // ¿Son el mismo objeto? NO
		System.out.println("¿Contienen lo mismo? " + usuario.equals(javier)); // ¿Contienen lo mismo? NO?!?!?!?!?
		
		System.out.println(usuario.getId().equals(javier.getId()));
		System.out.println(usuario.getNombre().equals(javier.getNombre()));
		System.out.println(usuario.getFechaUltimaConexion().equals(javier.getFechaUltimaConexion()));
		
		Usuario copia = new Usuario(usuario); //usuario;
		
		System.out.println(usuario);
		System.out.println(copia);
		
		copia.setNombre("Cambiado");

		System.out.println(usuario);
		System.out.println(copia);
	}

}
