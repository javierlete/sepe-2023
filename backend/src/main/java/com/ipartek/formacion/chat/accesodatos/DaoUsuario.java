package com.ipartek.formacion.chat.accesodatos;

import java.time.LocalDateTime;

import com.ipartek.formacion.chat.pojos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	public Iterable<Usuario> buscarPorNombre(String nombre);
	public Iterable<Usuario> buscarPorUltimaConexion(LocalDateTime fecha);
	public Iterable<Usuario> buscarPorRangoDeFechas(LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
