'use strict';

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

	$('#login form').on('submit', async function (e) {
		e.preventDefault();

		const email = $('#email').val();
		const password = $('#password').val();

		usuario = await validarUsuario(email, password);

		console.log(usuario);

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

	$('#prestados').on('show.bs.offcanvas', function () {
		$('.offcanvas-body .list-group').empty();

		$(usuario.libros).each(function() {
			$('.offcanvas-body .list-group').append('<li class="list-group-item">' + this.titulo + '</li>');
		});
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

async function mostrar(idCapa, id) {
	ocultar();

	let libros;

	switch (idCapa) {
		case 'principal':
			libros = await obtenerLibros();
			console.log(libros);
			
			$('#listado-libros').empty();
			
			$(libros).each(function () {
				$('#listado-libros').append(`
				<div class="col">
					<div class="card h-100 mb-3">
						<div class="row g-0">
							<div class="col-4">
								<img src="https://picsum.photos/500/800?${this.id}" class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-8 mb-3">
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
							<div class="col-12 position-absolute bottom-0">
								<a class="w-100 stretched-link btn btn-primary" href="javascript:mostrar('detalle', ${this.id})">Ver
									más información</a>
							</div>
						</div>
					</div>
				</div>`)
			});

			break;
		case 'detalle':
			libro = await buscarLibro(id);

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