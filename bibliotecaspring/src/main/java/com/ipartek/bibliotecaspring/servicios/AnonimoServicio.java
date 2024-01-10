package com.ipartek.bibliotecaspring.servicios;

import com.ipartek.bibliotecaspring.entidades.Persona;

public interface AnonimoServicio {
	Persona iniciarSesion(String email, String password);
}
