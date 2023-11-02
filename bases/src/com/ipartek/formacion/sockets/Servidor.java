package com.ipartek.formacion.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private static final boolean AUTOFLUSH = true;

	public static void main(String[] args) {
		System.out.println("ARRANCANDO MAYUSCULATOR");
		
		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTOFLUSH);
				Scanner sc = new Scanner(s.getInputStream())) {
			System.out.println("Conexión recibida");
			
			pw.println("Bienvenido al servidor MAYUSCULATOR");
			
			String linea = sc.nextLine();
			
			pw.println(linea.toUpperCase());
		} catch (IOException e) {
			System.err.println("Error de conexión");
			e.printStackTrace();
		}
	}

}
