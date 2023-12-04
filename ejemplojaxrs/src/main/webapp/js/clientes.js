const URL = 'http://localhost:8080/ejemplojaxrs/api/v2/clientes/';

window.addEventListener('DOMContentLoaded', async function() {
	const respuesta = await fetch(URL);
	const clientes = await respuesta.json();
	
	const ul = document.querySelector('ul');
	let li;
	clientes.forEach(cliente => {
		li = document.createElement('li');
		li.innerText = cliente.nombre;
		
		ul.appendChild(li);
	});
});