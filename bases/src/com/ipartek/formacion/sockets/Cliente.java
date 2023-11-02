package com.ipartek.formacion.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	private static final boolean AUTOFLUSH = true;

	public static void main(String[] args) {
		System.out.println("ARRANCANDO CLIENTE MAYUSCULATOR");
		
		try (	Socket s = new Socket("localhost", 1234);
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTOFLUSH);
				Scanner sc = new Scanner(s.getInputStream())) {
			System.out.println("Conexión realizada");
			
			String linea = sc.nextLine();
			
			System.out.println(linea);
			
			pw.println("Texto para poner en mayúsculas");
			
			linea = sc.nextLine();
			
			System.out.println(linea);
		} catch (IOException e) {
			System.err.println("Error de conexión");
		}
	}

}
