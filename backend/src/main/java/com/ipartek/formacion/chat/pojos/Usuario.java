package com.ipartek.formacion.chat.pojos;

import java.time.LocalDateTime;
import java.util.Objects;

import com.ipartek.formacion.bibliotecas.LongId;

public class Usuario implements LongId {
	// Variables de instancia
	private Long id;
	private String nombre;
	private LocalDateTime fechaUltimaConexion = LocalDateTime.now();

	// Constructores: Source/Generate Constructor using Fields...
	public Usuario(Long id, String nombre, LocalDateTime fechaUltimaConexion) {
		// Sustituir por setters
		setId(id);
		setNombre(nombre);
		setFechaUltimaConexion(fechaUltimaConexion);
	}
	
	// "Constructor de copia"
	public Usuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNombre(), usuario.getFechaUltimaConexion());
	}
	
	public Usuario(String nombre, LocalDateTime fechaUltimaConexion) {
		this(null, nombre, fechaUltimaConexion);
	}
	
	public Usuario(String nombre) {
		this(null, nombre, LocalDateTime.now());
	}

	public Usuario() {
		this(null, "ANÓNIMO", LocalDateTime.now());
	}
	
	// Métodos de acceso: Source/Generate Getters and setters...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id != null && id < 0) {
			throw new RuntimeException("No se admiten ids menores que 0");
		}
		
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos");
		}
		
		this.nombre = nombre.trim();
	}
	public LocalDateTime getFechaUltimaConexion() {
		return fechaUltimaConexion;
	}
	public void setFechaUltimaConexion(LocalDateTime fechaUltimaConexion) {
		if(fechaUltimaConexion == null || fechaUltimaConexion.isAfter(LocalDateTime.now())) {
			throw new RuntimeException("No se admiten fechas futuras ni fechas sin rellenar");
		}
		
		this.fechaUltimaConexion = fechaUltimaConexion;
	}

	// Source/Generate hashCode() and equals()...	
	@Override
	public int hashCode() {
		return Objects.hash(fechaUltimaConexion, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(fechaUltimaConexion, other.fechaUltimaConexion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	// Source/Generate toString...
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaUltimaConexion=" + fechaUltimaConexion + "]";
	}

	
}
