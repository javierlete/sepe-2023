package com.ipartek.bibliotecaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.bibliotecaspring.entidades.Libro;
import com.ipartek.bibliotecaspring.repositorios.LibroRepository;
import com.ipartek.bibliotecaspring.repositorios.PersonaRepository;

@SpringBootApplication
public class BibliotecaspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaspringApplication.class, args);
	}

	@Autowired
	private LibroRepository repoLibro;
	
	@Autowired
	private PersonaRepository repoPersona;
	
	@Override
	public void run(String... args) throws Exception {
		for(Libro l: repoLibro.findAll()) {
			System.out.println(l);
		}
		
		for(Libro l: repoLibro.buscarPorTitulo("Señor")) {
			System.out.println(l);
		}
		
		for(Libro l: repoLibro.findByTituloContains("sombra")) {
			System.out.println(l);
		}
		
		System.out.println(repoPersona.findByEmail("pepe@email.net"));
	}

}
