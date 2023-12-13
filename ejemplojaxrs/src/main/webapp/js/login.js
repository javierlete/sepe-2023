const URL = '/ejemplojaxrs/api/v2/login';

window.addEventListener('DOMContentLoaded', function() {
	const email = document.querySelector('#email');
	const password = document.querySelector('#password');

	const cabecera = document.querySelector('#cabecera');
	const nombre = document.querySelector('#nombre');
	const rol = document.querySelector('#rol');

	const form = document.querySelector('form');

	form.addEventListener('submit', async function(e) {
		e.preventDefault();
		
		const respuesta = await fetch(`${URL}?email=${email.value}&password=${password.value}`);

		if (respuesta.status == 204) {
			alert('El login no es correcto');
			return;
		}
		
		const usuario = await respuesta.json();
		
		console.log(usuario);
		
		cabecera.innerText = usuario.email;
		nombre.innerText = usuario.nombre;
		rol.innerText = usuario.rol.nombre;
	});

});