package com.ipartek.formacion.ejemplojaxrs.global;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoCliente;
import com.ipartek.formacion.ejemplojaxrs.repositorios.DaoUsuario;
import com.ipartek.formacion.ejemplojaxrs.servicios.ClienteServicio;
import com.ipartek.formacion.ejemplojaxrs.servicios.LoginServicio;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class FabricaImpl implements Fabrica {

	private DaoCliente clienteDao;
	private DaoUsuario usuarioDao;
	
	private ClienteServicio clienteServicio;
	private LoginServicio loginServicio;

	private Validator validator;

	public static Fabrica construir(String ruta) {
		return new FabricaImpl(ruta);
	}

	private FabricaImpl(String ruta) {
		try {
			Properties props = new Properties();
			props.load(FabricaImpl.class.getClassLoader().getResourceAsStream(ruta));

			String nombreClaseServiciosCliente = props.getProperty("servicios.cliente");
			String nombreClaseServiciosLogin = props.getProperty("servicios.login");
			
			String nombreClaseRepositorioCliente = props.getProperty("repositorios.dao.cliente");
			String nombreClaseRepositorioUsuario = props.getProperty("repositorios.dao.usuario");

			String driver = props.getProperty("repositorios.jdbc.driver");
			String url = props.getProperty("repositorios.jdbc.url");
			String user = props.getProperty("repositorios.jdbc.user");
			String pass = props.getProperty("repositorios.jdbc.pass");

			clienteDao = (DaoCliente) Class.forName(nombreClaseRepositorioCliente)
					.getConstructor(String.class, String.class, String.class, String.class)
					.newInstance(driver, url, user, pass);
			usuarioDao = (DaoUsuario) Class.forName(nombreClaseRepositorioUsuario)
					.getConstructor(String.class, String.class, String.class, String.class)
					.newInstance(driver, url, user, pass);

//		clienteServicio = new com.ipartek.formacion.ejemplojaxrs.servicios.ClienteServicioImpl();
			Class<?> claseServiciosCliente = Class.forName(nombreClaseServiciosCliente);
			Constructor<?> constructorServiciosCliente = claseServiciosCliente.getConstructor(DaoCliente.class);
			clienteServicio = (ClienteServicio) constructorServiciosCliente.newInstance(clienteDao);

			loginServicio = (LoginServicio) Class.forName(nombreClaseServiciosLogin).getConstructor(DaoUsuario.class).newInstance(usuarioDao);
			
			validator = Validation.buildDefaultValidatorFactory().getValidator();
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException
				| ExceptionInInitializerError e) {
			throw new FabricaException("No se ha podido crear la fábrica", e);
		}
	}

	@Override
	public ClienteServicio getServicioCliente() {
		return clienteServicio;
	}

	@Override
	public DaoCliente getDaoCliente() {
		return clienteDao;
	}

	@Override
	public Validator getValidator() {
		return validator;
	}

	@Override
	public DaoUsuario getDaoUsuario() {
		return usuarioDao;
	}

	@Override
	public LoginServicio getServicioLogin() {
		return loginServicio;
	}

}
