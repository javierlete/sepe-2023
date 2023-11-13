package com.ipartek.formacion.chat.accesodatos;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import com.ipartek.formacion.bibliotecas.TablaMemoria;
import com.ipartek.formacion.chat.pojos.Usuario;

public class DaoUsuarioMemoria implements DaoUsuario {

	static final TablaMemoria<Usuario> usuarios = new TablaMemoria<>();
	
	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.select();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.select(id);
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		return usuarios.insert(usuario);
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		return usuarios.update(usuario);
	}

	@Override
	public void borrar(Long id) {
		usuarios.delete(id);
	}

	@Override
	public Iterable<Usuario> buscarPorNombre(String nombre) {
		return usuarios.values().stream().filter(u -> u.getNombre().contains(nombre)).toList();
	}

	@Override
	public Iterable<Usuario> buscarPorUltimaConexion(LocalDateTime fecha) {
		return usuarios.values().stream().filter(new Predicate<Usuario>() {
			@Override
			public boolean test(Usuario u) {
				return u.getFechaUltimaConexion().isAfter(fecha);
			}
		}).toList();
}

	@Override
	public Iterable<Usuario> buscarPorRangoDeFechas(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		FiltroFecha ff = new FiltroFecha(fechaInicial, fechaFinal);
		
		return usuarios.values().stream().filter(ff).toList();
	}

	public static class FiltroFecha implements Predicate<Usuario> {
		private LocalDateTime fechaInicial, fechaFinal;
		
		public FiltroFecha(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
			this.fechaFinal = fechaFinal;
			this.fechaInicial = fechaInicial;
		}
		
		@Override
		public boolean test(Usuario u) {
			return u.getFechaUltimaConexion().isAfter(fechaInicial) && u.getFechaUltimaConexion().isBefore(fechaFinal);
		}
	}

	@Override
	public void borrar() {
		usuarios.clear();
	}

	@Override
	public int tamano() {
		return usuarios.size();
	}
}
