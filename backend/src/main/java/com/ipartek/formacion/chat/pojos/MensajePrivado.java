package com.ipartek.formacion.chat.pojos;

import java.time.LocalDateTime;
import java.util.Objects;

public class MensajePrivado extends Mensaje {
	private Usuario destinatario;

	public MensajePrivado(Long id, String texto, Usuario usuario, LocalDateTime fechaHora, Usuario destinatario) {
		super(id, texto, usuario, fechaHora);
		setDestinatario(destinatario);
	}
	
	public MensajePrivado(Long id, String texto, Usuario usuario, Usuario destinatario) {
		this(id, texto, usuario, null, destinatario);
	}
	
	public MensajePrivado(String texto, Usuario usuario, Usuario destinatario) {
		this(null, texto, usuario, null, destinatario);
	}
	
	public Usuario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(destinatario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensajePrivado other = (MensajePrivado) obj;
		return Objects.equals(destinatario, other.destinatario);
	}

	@Override
	public String toString() {
		return "MensajePrivado [id=" + getId() + ", texto=" + getTexto()
				+ ", usuario=" + getUsuario() + ", fechaHora=" + getFechaHora() + ", toString()="
				+ ", destinatario=" + destinatario + "]";
	}
}
