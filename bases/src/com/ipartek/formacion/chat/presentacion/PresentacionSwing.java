package com.ipartek.formacion.chat.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.ipartek.formacion.chat.accesodatos.DaoUsuario;
import com.ipartek.formacion.chat.accesodatos.DaoUsuarioMemoria;
import com.ipartek.formacion.chat.negocio.UsuarioNegocio;
import com.ipartek.formacion.chat.negocio.UsuarioNegocioImpl;
import com.ipartek.formacion.chat.pojos.Usuario;

public class PresentacionSwing {

	private JFrame frame;
	private JTextArea taListado;
	
	static {
		DaoUsuario dao = new DaoUsuarioMemoria();
		
		dao.insertar(new Usuario("Prueba1"));
		dao.insertar(new Usuario("Prueba2"));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionSwing window = new PresentacionSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PresentacionSwing() {
		initialize();
		
		UsuarioNegocio un = new UsuarioNegocioImpl();
		
		StringBuffer sb = new StringBuffer();
		
		for(Usuario u: un.listado()) {
			sb.append(u).append("\r\n");
		}
		
		taListado.setText(sb.toString());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		taListado = new JTextArea();
		frame.getContentPane().add(taListado, BorderLayout.CENTER);
	}

}
