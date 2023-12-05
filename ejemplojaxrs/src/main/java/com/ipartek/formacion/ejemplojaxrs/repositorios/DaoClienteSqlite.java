package com.ipartek.formacion.ejemplojaxrs.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.ipartek.formacion.ejemplojaxrs.entidades.Cliente;

public class DaoClienteSqlite implements DaoCliente {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:/sqlite/ejemplojaxrs.db";
	private static final String USER = "";
	private static final String PASS = "";
	
	private static final String SQL_SELECT = "SELECT id, nombre, apellidos, dni, telefono, direccion, codigo_postal FROM clientes";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_SELECT_DNI = SQL_SELECT + " WHERE dni = ?";
	private static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM clientes";
	
	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, dni, telefono, direccion, codigo_postal) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE clientes SET nombre=?, apellidos=?, dni=?, telefono=?, direccion=?, codigo_postal=? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM clientes WHERE id = ?";
	private static final String SQL_DELETE_TODOS = "DELETE FROM clientes";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RepositoriosException("No se ha encontrado el driver de base de datos", e);
		}
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido establecer la conexión con la base de datos", e);
		}
	}

	@Override
	public Collection<Cliente> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			
			var clientes = new ArrayList<Cliente>();
			Cliente cliente;

			while (rs.next()) {
				cliente = Cliente.builder().id(rs.getLong("id")).dni(rs.getString("dni")).telefono(rs.getString("telefono"))
						.nombre(rs.getString("nombre")).apellidos(rs.getString("apellidos"))
						.direccion(rs.getString("direccion")).codigoPostal(rs.getString("codigo_postal")).build();
				
				clientes.add(cliente);
			}
			
			return clientes;
		} catch (SQLException e) {
			throw new RepositoriosException("No se han podido obtener los registros", e);
		}
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Cliente cliente = null;

			if (rs.next()) {
				cliente = Cliente.builder().id(rs.getLong("id")).dni(rs.getString("dni")).telefono(rs.getString("telefono"))
						.nombre(rs.getString("nombre")).apellidos(rs.getString("apellidos"))
						.direccion(rs.getString("direccion")).codigoPostal(rs.getString("codigo_postal")).build();
			}
			
			return cliente;
			
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido obtener el registro id " + id, e);
		}
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);
				) {
			
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getApellidos());
			pst.setString(3, cliente.getDni());
			pst.setString(4, cliente.getTelefono());
			pst.setString(5, cliente.getDireccion());
			pst.setString(6, cliente.getCodigoPostal());
			
			pst.executeUpdate();
			
			return cliente;
			
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido insertar el cliente " + cliente, e);
		}
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
				) {
			
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getApellidos());
			pst.setString(3, cliente.getDni());
			pst.setString(4, cliente.getTelefono());
			pst.setString(5, cliente.getDireccion());
			pst.setString(6, cliente.getCodigoPostal());
			pst.setLong(7, cliente.getId());
			
			pst.executeUpdate();
			
			return cliente;
			
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido modificar el cliente " + cliente, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				) {
			
			pst.setLong(1, id);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido borrar el registro id " + id, e);
		}
	}

	@Override
	public void borrar() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_TODOS);
				) {
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RepositoriosException("No se han podido borrar los registros", e);
		}
	}

	@Override
	public int tamano() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_COUNT);
				ResultSet rs = pst.executeQuery()) {
			
			rs.next();
			
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido obtener cuantos registros hay", e);
		}
	}

	@Override
	public Cliente obtenerPorDni(String dni) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_DNI);
				) {
			
			pst.setString(1, dni);
			
			ResultSet rs = pst.executeQuery();
			
			Cliente cliente = null;

			if (rs.next()) {
				cliente = Cliente.builder().id(rs.getLong("id")).dni(rs.getString("dni")).telefono(rs.getString("telefono"))
						.nombre(rs.getString("nombre")).apellidos(rs.getString("apellidos"))
						.direccion(rs.getString("direccion")).codigoPostal(rs.getString("codigo_postal")).build();
			}
			
			return cliente;
			
		} catch (SQLException e) {
			throw new RepositoriosException("No se ha podido obtener el registro dni " + dni, e);
		}
	}
	
	
}
