'use strict';

const libros = [
	{ id: 1, titulo: 'Yo Robot', descripcion: 'Novela de ciencia ficción con robots y leyes de la robótica.', isbn: '97884350213401', unidades: 5, genero: 'Ciencia ficción', autor: 'Isaac Asimov', prestamo: null },
	{ id: 2, titulo: '1984', descripcion: 'Distopía sobre un régimen totalitario y vigilancia extrema.', isbn: '9780451524935', unidades: 4, genero: 'Distopía', autor: 'George Orwell', prestamo: null },
	{ id: 3, titulo: 'Fahrenheit 451', descripcion: 'Una sociedad que prohíbe y quema libros en un futuro distópico.', isbn: '9781451673319', unidades: 6, genero: 'Ciencia ficción', autor: 'Ray Bradbury', prestamo: null },
	{ id: 4, titulo: 'El señor de las moscas', descripcion: 'Historia de supervivencia de niños en una isla desierta.', isbn: '9780571295715', unidades: 7, genero: 'Aventura', autor: 'William Golding', prestamo: null },
	{ id: 5, titulo: 'Orgullo y Prejuicio', descripcion: 'Clásico de la literatura romántica y crítica social.', isbn: '9780141439518', unidades: 3, genero: 'Romance', autor: 'Jane Austen', prestamo: null },
	{ id: 6, titulo: 'Matar a un ruiseñor', descripcion: 'Novela sobre prejuicios raciales y justicia en la gran depresión.', isbn: '9780060935467', unidades: 5, genero: 'Drama', autor: 'Harper Lee', prestamo: null },
	{ id: 7, titulo: 'La sombra del viento', descripcion: 'Intriga y misterio en la Barcelona de posguerra.', isbn: '9780143126393', unidades: 5, genero: 'Misterio', autor: 'Carlos Ruiz Zafón', prestamo: null },
	{ id: 8, titulo: 'El nombre del viento', descripcion: 'La historia de un joven músico convertido en poderoso mago.', isbn: '9780756404741', unidades: 4, genero: 'Fantasía', autor: 'Patrick Rothfuss', prestamo: null },
	{ id: 9, titulo: 'Los juegos del hambre', descripcion: 'Tributos adolescentes luchan en un mortal reality show.', isbn: '9780439023481', unidades: 6, genero: 'Ciencia ficción', autor: 'Suzanne Collins', prestamo: null },
	{ id: 10, titulo: 'El principito', descripcion: 'Fábula filosófica sobre un niño que viaja por el universo.', isbn: '9780156012195', unidades: 8, genero: 'Fábula', autor: 'Antoine de Saint-Exupéry', prestamo: null },
	{ id: 11, titulo: 'Cien años de soledad', descripcion: 'Saga familiar en el mítico pueblo de Macondo.', isbn: '9780060883287', unidades: 3, genero: 'Realismo mágico', autor: 'Gabriel García Márquez', prestamo: null },
];

const personas = [
	{ id: 1, email: 'javier@email.net', password: 'javier', nombre: 'Javier', dni: '12345678Z', rol: 'ADMIN', libros: [] },
	{ id: 2, email: 'pepe@email.net', password: 'pepe', nombre: 'Pepe', dni: '87654321X', rol: 'USUARIO', libros: [] },
];

let usuario;
let modalReserva;
let libro;

$(function () {
	modalReserva = new bootstrap.Modal('#modal-reserva');

	mostrar('login');

	new DataTable('#listado', {
		language: {
			url: 'json/es-ES.json',
		},
	});

	$('#login form').on('submit', function (e) {
		e.preventDefault();

		const email = $('#email').val();
		const password = $('#password').val();

		usuario = personas.filter(p => p.email === email && p.password === password)[0];

		if (usuario) {
			alerta('Bienvenido ' + usuario.nombre, 'success');

			mostrar('principal');
		} else {
			alerta('Usuario o contraseña incorrectos', 'danger');

			$('#password').val('');
			$('#password').focus();
		}

	});

	$('#formulario form').on('submit', function (e) {
		if (this.checkValidity()) {
			alert('Aceptando datos');
		} else {
			e.preventDefault();
			$(this).addClass('was-validated');
		}
	})

	$('#modal-reserva').on('hidden.bs.modal', function () {
		mostrar('principal');
	});

	$('#libro-reservar').on('click', function () {
		if (usuario) {
			usuario.libros.push(libro);
			
			abrirModal(libro);
		} else {
			alerta('Debes iniciar sesión para poder reservar un libro', 'danger');
			mostrar('login');
		}
	});
});

function reservar() {
	alerta('Reservado', 'success');
}

function devolver() {
	alert('devolver');
}

function borrar() {
	alert('borrar');
}

function ocultar() {
	$('section').hide();
}

function mostrar(idCapa, id) {
	ocultar();

	switch (idCapa) {
		case 'principal':
			$(libros).each(function () {
				$('#listado-libros').append(`
				<div class="col">
					<div class="card mb-3">
						<div class="row g-0">
							<div class="col-4">
								<img src="https://picsum.photos/500/800?${this.id}" class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-8">
								<div class="card-body">
									<h5 class="card-title">${this.titulo}</h5>
									<ul class="list-group list-group-flush">
										<li class="list-group-item">Autor: ${this.autor}</li>
										<li class="list-group-item">Género: ${this.genero}</li>
									</ul>
									<p class="card-text">
										<small class="text-body-secondary">${this.unidades} libros disponibles</small>
									</p>
									<p class="card-text">
										<small class="text-body-secondary">${this.isbn}</small>
									</p>
								</div>
							</div>
							<div class="col-12">
								<a class="w-100 stretched-link btn btn-primary" href="javascript:mostrar('detalle', ${this.id})">Ver
									más información</a>
							</div>
						</div>
					</div>
				</div>`)
			});

			break;
		case 'detalle':
			libro = libros.filter(l => l.id == id)[0];

			$('#libro-titulo').html(libro.titulo);
			$('#libro-descripcion').html(libro.descripcion);
			$('#libro-autor').html(libro.autor);
			$('#libro-genero').html(libro.genero);
			$('#libro-unidades').html(libro.unidades);
			$('#libro-isbn').html(libro.isbn);

			

			break;
	}

	$('#' + idCapa).show();
}

function alerta(texto, nivel) {
	console.log(texto, nivel);
	$('#alerta').remove();
	$('<div id="alerta" role="alert" class="alert alert-dismissible fade show">').html(texto + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>').addClass('alert-' + nivel).insertAfter('.navbar').show();
}

function abrirModal(libro) {
	$('#modal-reserva').find('.modal-body').html('Has reservado el libro ' + libro.titulo);
	modalReserva.show();
}

function cerrarModal() {
	modalReserva.hide();
}