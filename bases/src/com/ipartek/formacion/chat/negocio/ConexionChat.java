package com.ipartek.formacion.chat.negocio;

import com.ipartek.formacion.chat.pojos.Sala;

public class ConexionChat extends Thread {
	private int posicion = 0;

	private Sala sala;
	private ConexionUsuario conexionUsuario;

	public ConexionChat(Sala sala, ConexionUsuario conexionUsuario) {
		this.sala = sala;
		this.conexionUsuario = conexionUsuario;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			var mensajes = sala.getMensajes();

			int i;

			for (i = posicion; i < mensajes.length; i++) {
				conexionUsuario.mensajeChat(mensajes[i]);
			}

			posicion = i;
		}
	}
}
