'use strict';

let form, table, inputId, inputNombre, inputFecha;

const URL = 'http://localhost:8080/backend/api/v1/usuarios';

window.addEventListener('DOMContentLoaded', async function() {
	form = document.querySelector('form');
	table = document.querySelector('table');

	inputId = document.querySelector('#id');
	inputNombre = document.querySelector('#nombre');
	inputFecha = document.querySelector('#fecha');

	form.style.display = 'none';

	form.addEventListener('submit', guardar);

	await recargarTabla();
});

async function guardar(e) {
	e.preventDefault();

	table.style.display = 'table';
	form.style.display = 'none';

	if (inputId.value) {
		const usuario = { id: inputId.value, nombre: inputNombre.value, fechaUltimaConexion: inputFecha.value };

		await fetch(`${URL}/${inputId.value}`, {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(usuario)
		});
	} else {
		const usuario = { nombre: inputNombre.value, fechaUltimaConexion: inputFecha.value };

		await fetch(URL, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(usuario)
		});
	}

	recargarTabla();
}
async function recargarTabla() {
	const respuesta = await fetch(URL);
	const usuarios = await respuesta.json();

	const tbody = document.querySelector('tbody');

	tbody.innerHTML = '';

	usuarios.forEach(usuario => {
		const tr = document.createElement('tr');
		tr.innerHTML = `
            <td>${usuario.id}</td>
            <td>${usuario.nombre}</td>
            <td>${usuario.fechaUltimaConexion}</td>
            <td>
                <a href="javascript:formulario(${usuario.id})">Editar</a>
                <a href="javascript:borrar(${usuario.id})">Borrar</a>
            </td>
            `;

		tbody.appendChild(tr);
	});
}

async function formulario(id) {
	if (id) {
		const respuesta = await fetch(`${URL}/${id}`);

		console.log(respuesta);

		if (respuesta.status === 404) {
			await recargarTabla();
			alert('No se ha encontrado el registro y se ha refrescado la tabla con sus valores actuales');
			return;
		}

		const usuario = await respuesta.json();

		inputId.value = usuario.id;
		inputNombre.value = usuario.nombre;
		inputFecha.value = usuario.fechaUltimaConexion;
	} else {
		inputId.value = '';
		inputNombre.value = '';
		inputFecha.value = '';
	}

	table.style.display = 'none';
	form.style.display = 'block';
}

async function borrar(id) {
	const quiereBorrar = confirm(`¿Estás seguro de que quieres borrar el registro id ${id}?`);

	if (quiereBorrar) {
		await fetch(`${URL}/${id}`, { method: 'DELETE' });
		recargarTabla();
	}
}