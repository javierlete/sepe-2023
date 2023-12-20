'use strict';

$(function() {
	mostrar('formulario');

	new DataTable('#listado', {
		language: {
			url: 'json/es-ES.json',
		},
	});

	$('#login form').on('submit', function(e) {
		e.preventDefault();
		mostrar('principal');
	});

	$('#modal-reserva').on('hidden.bs.modal', function() {
		mostrar('principal');
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
	$('#alerta').hide();
}

function mostrar(id) {
	ocultar();
	$('#' + id).show();
}

function alerta(texto, nivel) {
	$('#alerta').show().html(texto).addClass('alert-' + nivel);
}