package com.biblioteca.mockups;

import java.util.HashMap;
import java.util.Map;

import com.biblioteca.entidades.Libro;
import com.biblioteca.entidades.Persona;

public class Mockups {
	public static final Map<Long, Libro> libros = new HashMap<>();
	public static final Map<String, Persona> personas = new HashMap<>();
	
	static {
		personas.put("javier@email.net", Persona.builder().id(1L).nombre("Javier").email("javier@email.net").password("javier").dni("12345678Z").rol("ADMIN").build());
		personas.put("pepe@email.net", Persona.builder().id(2L).nombre("Pepe").email("pepe@email.net").password("pepe").dni("12345678Z").rol("USER").build());

		libros.put(1L, Libro.builder().id(1L).titulo("El código Da Vinci").autor("Dan Brown").genero("Misterio").isbn("9780307474278").descripcion("La trama gira en torno a un supuesto complot del Opus Dei y el Vaticano para encubrir la verdadera historia de Jesucristo. ").unidades(1).build());
		libros.put(2L, Libro.builder().id(2L).titulo("El alquimista").autor("Paulo Coelho").genero("Ficción").isbn("9780061122415").descripcion("La historia sigue a Santiago, un joven pastor andaluz que tiene un sueño recurrente que le indica que debe viajar en busca de un tesoro escondido en las Pirámides de Egipto. ").unidades(1).build());
		libros.put(3L, Libro.builder().id(3L).titulo("Cien años de soledad").autor("Gabriel García Márquez").genero("Realismo mágico").isbn("9780307474728").descripcion("La novela narra la historia de la familia Buendía a lo largo de siete generaciones en el pueblo ficticio de Macondo. ").unidades(1).build());
		libros.put(4L, Libro.builder().id(4L).titulo("La sombra del viento").autor("Carlos Ruiz Zafón").genero("Misterio").isbn("9788408163387").descripcion("La trama sigue a Daniel Sempere, un joven que descubre un libro en la Biblioteca de los Libros Olvidados y se propone encontrar más obras del autor. ").unidades(1).build());
		libros.put(5L, Libro.builder().id(5L).titulo("El nombre del viento").autor("Patrick Rothfuss").genero("Fantasía").isbn("9788401352836").descripcion("La historia sigue a Kvothe, un músico y mago que narra su propia vida a un cronista. ").unidades(1).build());
		libros.put(6L, Libro.builder().id(6L).titulo("El señor de los anillos").autor("J.R.R. Tolkien").genero("Fantasía").isbn("9788445000663").descripcion("La trama sigue a Frodo Bolsón, un hobbit que debe destruir el Anillo Único para evitar que caiga en manos del Señor Oscuro Sauron. ").unidades(1).build());
		libros.put(7L, Libro.builder().id(7L).titulo("Harry Potter y la piedra filosofal").autor("J.K. Rowling").genero("Fantasía").isbn("9788478884459").descripcion("La historia sigue a Harry Potter, un niño huérfano que descubre que es un mago y asiste a la escuela de magia Hogwarts. ").unidades(1).build());
		libros.put(8L, Libro.builder().id(8L).titulo("1984").autor("George Orwell").genero("Ciencia ficción").isbn("9788423342596").descripcion("La novela presenta una sociedad totalitaria en la que el gobierno controla todos los aspectos de la vida de las personas. ").unidades(1).build());
		libros.put(9L, Libro.builder().id(9L).titulo("El gran Gatsby").autor("F. Scott Fitzgerald").genero("Ficción").isbn("9788491050563").descripcion("La trama sigue a Jay Gatsby, un hombre adinerado que vive en Long Island durante la década de 1920. ").unidades(1).build());
		libros.put(10L, Libro.builder().id(10L).titulo("Matar a un ruiseñor").autor("Harper Lee").genero("Ficción").isbn("9788490321475").descripcion("La historia sigue a Scout Finch, una niña que vive en Alabama durante la Gran Depresión y su padre, un abogado que defiende a un hombre negro acusado de violación. ").unidades(1).build());
	}
}
