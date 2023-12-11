'use strict';

const URL = 'http://localhost:8080/ejemplojaxrs/api/v2/clientes/';

let inputId, inputNombre, inputApellidos, inputDni, inputTelefono, inputDireccion, inputCodigoPostal;
let form, inputs;

window.addEventListener('DOMContentLoaded', async function() {
	inputs = document.querySelectorAll('input');

	inputId = document.querySelector('#id');
	inputNombre = document.querySelector('#nombre');
	inputApellidos = document.querySelector('#apellidos');
	inputDni = document.querySelector('#dni');
	inputTelefono = document.querySelector('#telefono');
	inputDireccion = document.querySelector('#direccion');
	inputCodigoPostal = document.querySelector('#codigoPostal');

	form = document.querySelector('form');

	form.addEventListener('submit', procesarEnvioFormulario);

	await rellenarTabla();
	
	new DataTable('table');
});


async function procesarEnvioFormulario(e) {
	e.preventDefault();

	resetearEstadoFormulario();

	const cliente = camposACliente();

	let respuesta;

	if (cliente.id) {
		// PUT
		respuesta = await lanzaModificacion(cliente);
	} else {
		// POST
		respuesta = await lanzaInsercion(cliente);
	}

	if (!respuesta.ok) {
		await erroresAFormulario(respuesta);
	} else {
		vaciarFormulario();
	}

	console.log(cliente);

	await rellenarTabla();
}

function resetearEstadoFormulario() {
	let mensaje;

	for (const input of inputs) {
		input.classList.remove('is-invalid');
		mensaje = input.nextElementSibling;
		mensaje.innerText = '';
	}
}

function camposACliente() {
	return {
		id: +inputId.value,
		nombre: inputNombre.value,
		apellidos: inputApellidos.value,
		dni: inputDni.value,
		telefono: inputTelefono.value,
		direccion: inputDireccion.value,
		codigoPostal: inputCodigoPostal.value
	};
}

async function lanzaModificacion(cliente) {
	const respuesta = await fetch(URL + cliente.id, {
		method: 'PUT',
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify(cliente)
	});

	console.log(respuesta);

	return respuesta;
}

async function lanzaInsercion(cliente) {
	const respuesta = await fetch(URL, {
		method: 'POST',
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify(cliente)
	});

	console.log(respuesta);

	return respuesta;
}


async function erroresAFormulario(respuesta) {
	const errores = await respuesta.json();

	console.log(errores);

	let input, mensaje;

	for (const clave in errores) {
		input = document.querySelector('#' + clave);

		mensaje = input.nextElementSibling;
		mensaje.innerText = errores[clave];

		input.classList.add('is-invalid');
	};
}

function vaciarFormulario() {
	form.reset();

	for (const input of inputs) {
		input.classList.remove('is-invalid');
		input.classList.remove('is-valid');
	}
}

async function rellenarTabla() {
	const respuesta = await fetch(URL);
	const clientes = await respuesta.json();

	const tbody = document.querySelector('tbody');
	tbody.innerHTML = "";
	let tr;
	clientes.forEach(c => {
		tr = document.createElement('tr');
		tr.innerHTML = `
			<th>${c.id || ''}</th>
			<td>${c.nombre || ''}</td>
			<td>${c.apellidos || ''}</td>
			<td>${c.dni || ''}</td>
			<td>${c.telefono || ''}</td>
			<td>${c.direccion || ''}</td>
			<td>${c.codigoPostal || ''}</td>
			<td>
				<a class="btn btn-sm btn-primary" href="javascript:editar(${c.id})">Editar</a>
				<a class="btn btn-sm btn-danger" href="javascript:borrar(${c.id})">Borrar</a>
			</td>
		`;
		tbody.appendChild(tr);
	});
}

async function editar(id) {
	if (id) {
		const respuesta = await fetch(URL + id);
		const cliente = await respuesta.json();

		console.log(cliente);
		console.log(cliente.id);

		clienteACampos(cliente);
	}
}

function clienteACampos(cliente) {
	inputId.value = cliente.id || '';
	inputNombre.value = cliente.nombre || '';
	inputApellidos.value = cliente.apellidos || '';
	inputDni.value = cliente.dni || '';
	inputTelefono.value = cliente.telefono || '';
	inputDireccion.value = cliente.direccion || '';
	inputCodigoPostal.value = cliente.codigoPostal || '';
}

async function borrar(id) {
	if (id) {
		const respuesta = await fetch(URL + id, { method: 'DELETE' });

		console.log(respuesta);

		await rellenarTabla();
	}
}
