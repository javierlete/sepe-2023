package com.ipartek.formacion.chat.pojos;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje {
	private Long id;
	private String texto;
	private LocalDateTime fechaHora;

	private Usuario usuario;

	public Mensaje(Long id, String texto, Usuario usuario, LocalDateTime fechaHora) {
		setId(id);
		setTexto(texto);
		setUsuario(usuario);
		setFechaHora(fechaHora);
	}
	
	public Mensaje(Long id, String texto, Usuario usuario) {
		this(id, texto, usuario, LocalDateTime.now());
	}
	
	public Mensaje(Mensaje mensaje) {
		this(mensaje.getId(), mensaje.getTexto(), mensaje.getUsuario());
	}
	
	public Mensaje(String texto, Usuario usuario) {
		this(null, texto, usuario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		if(texto == null || texto.trim().length() == 0) {
			throw new RuntimeException("No se admiten textos vacíos");
		}
		
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if(usuario == null) {
			throw new RuntimeException("Se DEBE especificar el usuario");
		}
		
		this.usuario = usuario;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaHora, id, texto, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(fechaHora, other.fechaHora) && Objects.equals(id, other.id)
				&& Objects.equals(texto, other.texto) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", texto=" + texto + ", fechaHora=" + fechaHora + ", usuario=" + usuario + "]";
	}
}
