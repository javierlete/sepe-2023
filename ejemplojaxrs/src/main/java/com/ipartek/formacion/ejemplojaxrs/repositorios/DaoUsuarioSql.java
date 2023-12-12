package com.ipartek.formacion.ejemplojaxrs.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplojaxrs.entidades.Rol;
import com.ipartek.formacion.ejemplojaxrs.entidades.Usuario;

public class DaoUsuarioSql implements DaoUsuario {
	private String url;
	private String user;
	private String pass;

	private static final String SELECT_EMAIL = """
			SELECT
			    u.id AS u_id,
			    u.nombre AS u_nombre,
			    u.email AS u_email,
			    u.password AS u_password,
			    r.id AS r_id,
			    r.nombre AS r_nombre,
			    r.descripcion AS r_descripcion
			FROM
			    usuarios AS u
			        JOIN
			    roles AS r ON u.roles_id = r.id
			WHERE
				u.email = ?;
			""";

	public DaoUsuarioSql(String driver, String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RepositoriosException("No se ha encontrado el driver de base de datos", e);
		}
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido establecer la conexión con la base de datos", e);
		}
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SELECT_EMAIL)) {
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;
			Rol rol = null;

			if (rs.next()) {
				rol = Rol.builder().id(rs.getLong("r_id")).nombre(rs.getString("r_nombre"))
						.descripcion(rs.getString("r_descripcion")).build();
				usuario = Usuario.builder().id(rs.getLong("u_id")).nombre(rs.getString("u_nombre"))
						.email(rs.getString("u_email")).password(rs.getString("u_password")).rol(rol).build();
				
				rol.getUsuarios().add(usuario);
			}

			return usuario;
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido buscar por el email " + email, e);
		}
	}

}
