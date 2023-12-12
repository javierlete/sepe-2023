package com.ipartek.formacion.ejemplojaxrs.servicios;

import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;

public interface LoginServicio {
	Usuario validarUsuario(String email, String password);
}
