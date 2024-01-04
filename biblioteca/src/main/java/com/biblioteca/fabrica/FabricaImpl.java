package com.biblioteca.fabrica;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class FabricaImpl implements Fabrica {
	private HashMap<Class<?>, Object> almacen = new HashMap<>();

	public FabricaImpl() {
		try {
			Properties props = new Properties();
			props.load(FabricaImpl.class.getClassLoader().getResourceAsStream("fabrica.properties"));

			props.entrySet().stream().forEach(par -> {
				try {
					String clave = (String) par.getKey();
					String valor = (String) par.getValue();

					Class<?> interfaz = Class.forName(clave);
					Object objeto = Class.forName(valor).getConstructor().newInstance();
					
					almacen.put(interfaz, objeto);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public <T> T obtenerObjeto(Class<T> tipo) {
		return tipo.cast(almacen.get(tipo));
	}
}
