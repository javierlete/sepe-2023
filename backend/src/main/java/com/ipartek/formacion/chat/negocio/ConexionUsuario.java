package com.ipartek.formacion.chat.negocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.ipartek.formacion.chat.pojos.Mensaje;
import com.ipartek.formacion.chat.pojos.Sala;
import com.ipartek.formacion.chat.pojos.Usuario;

public class ConexionUsuario extends Thread {
	private static final String FORMATO_MENSAJE = "%s (%s): %s\r\n";

	private static final boolean AUTOFLUSH = true;
	
	private Sala sala;
	private Socket socket;
	private PrintWriter out;
	
	public ConexionUsuario(Sala sala, Socket socket) {
		this.sala = sala;
		this.socket = socket;
		
		try {
			out = new PrintWriter(socket.getOutputStream(), AUTOFLUSH);
		} catch (IOException e) {
			System.err.println("Error en la conexión");
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try (
				Scanner in = new Scanner(socket.getInputStream())) {
			out.println("Bienvenido a ChatServer");

			String nombreUsuario = in.nextLine();

			Usuario usuario = new Usuario(nombreUsuario);
			sala.addUsuario(usuario);

			out.println("Registrado: " + usuario);

			boolean salir = false;

			do {
				String texto = in.nextLine();

				switch(texto) {
				case "<SALIR>":
					salir = true;
					break;
				case "<HISTORIAL>":
					for(Mensaje m: sala.getMensajes()) {
						out.printf(FORMATO_MENSAJE, m.getUsuario().getNombre(), m.getFechaHora(), m.getTexto());
					}
					break;
				default:
					Mensaje mensaje = new Mensaje(texto, usuario);
					sala.addMensaje(mensaje);
				}
			} while (!salir);

			socket.close();
		} catch (IOException e) {
			System.err.println("Error de proceso de conexión de usuario");
			e.printStackTrace();
		}
	}

	public void mensajeChat(Mensaje mensaje) {
		out.printf(FORMATO_MENSAJE, mensaje.getUsuario().getNombre(), mensaje.getFechaHora(), mensaje.getTexto());
	}
}
