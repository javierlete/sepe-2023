package com.ipartek.formacion.chat.pojos;

import java.util.Objects;
import java.util.TreeMap;

public class Sala {
	private Long id;
	private String nombre;
	
	private TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	private TreeMap<Long, Mensaje> mensajes = new TreeMap<>();
	
	public Sala(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public Sala(String nombre) {
		this(null, nombre);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos");
		}
		
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + "]";
	}
	
	public void addUsuario(Usuario usuario) {
		Long id = usuarios.size() > 0 ? usuarios.lastKey() + 1L : 1L;
		usuario.setId(id);
		
		usuarios.put(id, usuario);
	}
	
	public void addMensaje(Mensaje mensaje) {
		Long id = mensajes.size() > 0 ? mensajes.lastKey() + 1L : 1L;
		mensaje.setId(id);
		
		mensajes.put(id, mensaje);
	}
	
	public Mensaje[] getMensajes() {
		return mensajes.values().toArray(new Mensaje[mensajes.size()]);
	}
	
	public Iterable<Usuario> getUsuarios() {
		return usuarios.values();
	}
}
