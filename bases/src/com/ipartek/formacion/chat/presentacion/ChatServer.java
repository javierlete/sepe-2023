package com.ipartek.formacion.chat.presentacion;

import java.net.ServerSocket;
import java.net.Socket;

import com.ipartek.formacion.chat.negocio.ConexionChat;
import com.ipartek.formacion.chat.negocio.ConexionUsuario;
import com.ipartek.formacion.chat.pojos.Sala;

public class ChatServer {
	

	public static void main(String[] args) throws Exception {
		System.out.println("Servidor ChatServer");
		
		var sala = new Sala("PÚBLICA");	
		
		
		try (var ss = new ServerSocket(1234)) {
			do {
				Socket s = ss.accept();
				
				var conexionUsuario = new ConexionUsuario(sala, s);
				conexionUsuario.start();
				
				var conexionChat = new ConexionChat(sala, conexionUsuario);
				conexionChat.start();
			} while (true);
		}
	}
}
