package com.ipartek.formacion.chat.pruebas;

import com.ipartek.formacion.chat.pojos.Mensaje;
import com.ipartek.formacion.chat.pojos.MensajePrivado;
import com.ipartek.formacion.chat.pojos.Sala;
import com.ipartek.formacion.chat.pojos.Usuario;

public class MensajePrivadoPrueba {
	public static void main(String[] args) {
		MensajePrivado mp = new MensajePrivado("Texto", new Usuario("Remitente"), new Usuario("Destinatario"));

		System.out.println(mp);

		Mensaje m = mp; // TODO MensajePrivado ES un Mensaje

//		System.out.println(m.getDestinatario()); // NO SE PUEDE

//		MensajePrivado mp2 = m; // ¿TODO Mensaje ES un MensajePrivado? NO

		if (m instanceof MensajePrivado mp2) {
//			MensajePrivado mp2 = (MensajePrivado) m;

			System.out.println(mp2.getDestinatario());
		} else {
			System.out.println("No se puede hacer el casting de m");
		}

		Mensaje m2 = new Mensaje("Texto simple", new Usuario("Remitente simple"));

		if (m2 instanceof MensajePrivado) {
			MensajePrivado mp3 = (MensajePrivado) m2; // ClassCastException

			System.out.println(mp3.getDestinatario());
		} else {
			System.out.println("No se puede hacer el casting de m2");
		}
		
		Sala sala = new Sala("Pruebas");
		
		sala.addMensaje(mp);
		sala.addMensaje(m2);
		
		for(Mensaje mensaje: sala.getMensajes()) {
			System.out.println(mensaje);
		}
		
		Object o = new Object();
		Object o2 = new Object();
		
		System.out.println(o.equals(o2));
		System.out.println(o.getClass().getName());
		System.out.println(o.hashCode());
		System.out.println(o.toString());
		System.out.println(o);
	}
}
