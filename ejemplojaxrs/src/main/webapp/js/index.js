'use strict';

const URL_PREFIJO = '/ejemplojaxrs';
const URL_REST = URL_PREFIJO + '/api/v2';
const URL_CLIENTES = URL_REST + '/clientes/';

const BOTON_CERRAR_ALERTA = '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';

let inputId, inputNombre, inputApellidos, inputDni, inputTelefono, inputDireccion, inputCodigoPostal;
let clienteForm, clienteTabla, inputs;
let table;
let alerta;

let login, listado, administracion, principal;
let loginForm, loginCard;
let inputEmail, inputPassword, loginCardCabecera, loginCardNombre, loginCardRol;
let menuAdmin, menuRolUsuario, menuUsuario;

window.addEventListener('DOMContentLoaded', function() {
	principal = document.querySelector('#principal');
	login = document.querySelector('#login');
	listado = document.querySelector('#listado');
	administracion = document.querySelector('#administracion');

	loginForm = document.querySelector('#login form');

	menuRolUsuario = document.querySelector('#rol-usuario');
	menuUsuario = document.querySelector('#usuario');
	menuAdmin = document.querySelector('#menu-admin');

	menuAdmin.style.display = 'none';

	ocultarTodas();

	loginProcesa();
	clienteProcesa();
	
	activarPrincipal();
});

function ocultarTodas() {
	listado.style.display = 'none';
	administracion.style.display = 'none';
	login.style.display = 'none';
	principal.style.display = 'none';
}

function mostrarCapa(capa) {
	ocultarTodas();
	capa.style.display = 'block';
}

async function activarPrincipal() {
	mostrarCapa(principal);

	const respuesta = await fetch(URL_CLIENTES);
	const clientes = await respuesta.json();

	let div;

	principal.querySelector('div').innerHTML = '';

	clientes.forEach(c => {
		div = document.createElement('div');
		div.className = 'col';

		div.innerHTML = `
			<div class="card h-100">
				<img src="https://picsum.photos/400/400?${c.id}" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${c.nombre}</h5>
					<p class="card-text">${c.apellidos}</p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary">${c.telefono}</small>
				</div>
			</div>
		`;
		
		principal.querySelector('div').appendChild(div);
	});
}

function clienteProcesa() {
	alerta = document.querySelector('.alert');

	ocultarAlerta();

	inputs = document.querySelectorAll('input');

	inputId = document.querySelector('#id');
	inputNombre = document.querySelector('#nombre');
	inputApellidos = document.querySelector('#apellidos');
	inputDni = document.querySelector('#dni');
	inputTelefono = document.querySelector('#telefono');
	inputDireccion = document.querySelector('#direccion');
	inputCodigoPostal = document.querySelector('#codigoPostal');

	clienteTabla = document.querySelector('#administracion .table-responsive');
	clienteForm = document.querySelector('#administracion form');

	clienteForm.addEventListener('submit', procesarEnvioFormulario);
}

function loginProcesa() {
	inputEmail = document.querySelector('#email');
	inputPassword = document.querySelector('#password');

	loginCardCabecera = document.querySelector('#card-cabecera');
	loginCardNombre = document.querySelector('#card-nombre');
	loginCardRol = document.querySelector('#card-rol');

	loginForm = document.querySelector('#login form');
	loginCard = document.querySelector('#login-card');

	loginCard.style.display = 'none';

	loginForm.addEventListener('submit', async function(e) {
		e.preventDefault();

		const respuesta = await fetch(`${URL_REST}/login?email=${inputEmail.value}&password=${inputPassword.value}`);

		if (respuesta.status == 204) {
			alert('El login no es correcto');
			return;
		}

		loginForm.style.display = 'none';

		const usuario = await respuesta.json();

		console.log(usuario);

		loginCardCabecera.innerText = usuario.email;
		loginCardNombre.innerText = usuario.nombre;
		loginCardRol.innerText = usuario.rol.nombre;

		loginCard.style.display = 'none';

		menuRolUsuario.innerText = usuario.rol.nombre;
		menuUsuario.innerText = usuario.nombre;

		if (usuario.rol.id === 1) {
			menuAdmin.style.display = 'list-item';
		} else {
			menuAdmin.style.display = 'none';
		}
	});
}

function activarLogin() {
	mostrarCapa(login);
}

async function activarAdministracion() {
	mostrarCapa(administracion);

	await rellenarTabla();
}

// ADMINISTRACION

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
	const respuesta = await fetch(URL_CLIENTES + cliente.id, {
		method: 'PUT',
		headers: { "Content-Type": "application/json" },
		body: JSON.stringify(cliente)
	});

	console.log(respuesta);

	return respuesta;
}

async function lanzaInsercion(cliente) {
	const respuesta = await fetch(URL_CLIENTES, {
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
	clienteForm.reset();

	for (const input of inputs) {
		input.classList.remove('is-invalid');
		input.classList.remove('is-valid');
	}
}

async function rellenarTabla() {
	clienteTabla.style.display = 'block';
	clienteForm.style.display = 'none';

	const respuesta = await fetch(URL_CLIENTES);

	if (!respuesta.ok) {
		const mensaje = 'No se han podido recibir los clientes';
		const nivel = 'danger';

		mostrarAlerta(mensaje, nivel);

		return;
	}

	const clientes = await respuesta.json();

	table && table.destroy();

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


	table = new DataTable('table', {
		language: {
			url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
		},
	});
}

function mostrarAlerta(mensaje, nivel) {
	alerta.classList.remove('alert-success');
	alerta.classList.remove('alert-warning');
	alerta.classList.remove('alert-danger');

	alerta.innerHTML = mensaje + BOTON_CERRAR_ALERTA;

	alerta.classList.add('alert-' + nivel);
	alerta.style.display = 'block';
}

function ocultarAlerta() {
	alerta.style.display = 'none';

	alerta.classList.remove('alert-success');
	alerta.classList.remove('alert-warning');
	alerta.classList.remove('alert-danger');

	alerta.innerHTML = BOTON_CERRAR_ALERTA;
}

async function editar(id) {
	clienteTabla.style.display = 'none';
	clienteForm.style.display = 'block';

	if (id) {
		const respuesta = await fetch(URL_CLIENTES + id);
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
		const respuesta = await fetch(URL_CLIENTES + id, { method: 'DELETE' });

		console.log(respuesta);

		await rellenarTabla();
	}
}
